package com.epi.controller;

import com.epi.bean.Article;
import com.epi.bean.Reply;
import com.epi.bean.User;
import com.epi.bean.Words;
import com.epi.service.ArticleService;
import com.epi.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/article")
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    //搜索功能
    @RequestMapping("/search")
    public String search(@RequestParam String rContent,@RequestParam String id, Model model){
        List<Article> list2=articleService.searchAll(rContent);
        model.addAttribute("userId",id);
        model.addAttribute("articleList",list2);
        return "article/listAll";
    }
    //分类
    @RequestMapping("/sort")
    public String findBySort(@RequestParam String r_sort,@RequestParam String id, Model model){
        if(r_sort==null || r_sort.isEmpty()){
            r_sort=r_sort+"";
        }
        User user = userService.selectByUserId(Integer.valueOf(id));
        System.out.print(id);
        model.addAttribute("userId",user.getUserId());
        List<Article> listSort=articleService.findBySort(r_sort);

        model.addAttribute("articleList",listSort);
        return "article/listAll";
    }

    @RequestMapping("/listAll")
    public String listAll(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        System.out.print(id);
        User user = userService.selectByUserId(Integer.valueOf(id));
        List<Article> list=articleService.findAll();
        model.addAttribute("articleList",list);
        model.addAttribute("userId",user.getUserId());
        return "article/listAll";

    }

    /**
     * 展示详情页面
     * @return
     */
    @RequestMapping("/showArticle")
    public String showMessage(){
        return "article/show";

    }
    // 长传信息
    @RequestMapping("/upFile")
    public String upFile(HttpServletRequest request, Model mv){
        String id = request.getParameter("id");
        User user =  userService.selectByUserId(Integer.valueOf(id));
        mv.addAttribute("user",user);
        return "article/upFile";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upImage(HttpServletRequest request,@RequestParam("author") String author, @RequestParam("description") String description,
                          @RequestParam("type") String type, @RequestParam("file") MultipartFile file,Model mv) throws Exception{
        // 获得上传文件名
        String fileName = file.getOriginalFilename();
        // 规定时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得现在的时间（字符串)
        String time = df.format(new Date());
        // 获得现在时间的格式(date）
        Date date = df.parse(time);
        // 文件的后缀名
        String ext = FilenameUtils.getExtension(fileName);
        // 获得上传文件的输入流
        InputStream inputStream = file.getInputStream();
        // 信息中介数组
        byte[] image1 = new byte[inputStream.available()];
        // 将文件内容写入image数组中
        inputStream.read(image1);
        // 关闭输入流
        inputStream.close();
        // 将时间设置为图片名称(秒)
        String imageName = time.replaceAll(" ","").replaceAll(":","");
        // 图片存入磁盘的路径
        String realUploadPath=request.getServletContext().getRealPath("/");
        System.out.println(realUploadPath);
        String inPath = "/upload/"+imageName+"."+ext;
        String inPath1 = "C:\\Users\\安康\\IdeaProjects\\hacker01（最终版）\\src\\main\\webapp\\upload"+imageName+"."+ext;
        // 文件路径的输出流
        OutputStream fileOutputStream = new FileOutputStream(new File(inPath1));
        // 写入信息
        fileOutputStream.write(image1);
        // 刷新和关闭
        fileOutputStream.flush();
        fileOutputStream.close();
        // 存入数据库
        Article article=new Article(author,type,inPath,time,description);
        articleService.insertProject(article);
        // 将user放入
        String id = request.getParameter("id");
        System.out.print(id);
        mv.addAttribute("userId",id);
        return "article/upFileSuccess";
    }

    // 长传成功进行跳转 回到主页面
    @RequestMapping("/toSuccess")
    public String toSuccess(){
        return "article/success";
    }

    /**
     * 保存留言信息
     */
    @RequestMapping(value="/saveWords")
    public String saveWords(Words words){
        if(words != null){
            String r_id = words.getLw_for_article_id();
            articleService.saveWords(words);
            return "redirect:/article/show.action?rId="+r_id;
        }else{
            return null;
        }
    }
    @RequestMapping("/show")
    public String show(@RequestParam Integer rId,@RequestParam String id, Model model){
        Article article=articleService.findById(rId);
        List<Words> wordsList=articleService.findByWords();
        List<Reply> replyList=articleService.findByReply();
        model.addAttribute("article",article);
        model.addAttribute("wordsList",wordsList);
        model.addAttribute("replyList",replyList);
        model.addAttribute("userId",id);
        return "article/show";
    }
    /**
     * 保存回复信息
     */
    @RequestMapping(value="/saveReply")
    public String saveReply(Reply reply){
        if(reply != null){
            articleService.saveReply(reply);
            String r_id = reply.getLr_for_article_id();
            return "redirect:/article/show.action?rId="+r_id;
        }else{
            return null;
        }
    }
}