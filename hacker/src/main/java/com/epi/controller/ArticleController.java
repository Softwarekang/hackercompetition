package com.epi.controller;

import com.epi.bean.Article;
import com.epi.bean.Reply;
import com.epi.bean.Words;
import com.epi.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String upFile(){
        return "article/upFile";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upImage(HttpServletRequest request, @RequestParam("author") String author, @RequestParam("description") String description,
                          @RequestParam("type") String type, @RequestParam("file") MultipartFile file) throws Exception{
        System.out.println("555");
        System.out.println(description+type);
        // 获得上传文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        // 规定时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得现在的时间（字符串)
        String time = df.format(new Date());
        // 获得现在时间的格式(date）
        Date date = df.parse(time);
        System.out.println(time);
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
        String inPath = "/images/"+imageName+"."+ext;
        String inPath1 = "C:\\Users\\安康\\IdeaProjects\\hacker\\src\\main\\webapp\\image\\"+imageName+"."+ext;
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
        return "article/upFileSuccess";
    }

    // 长传成功进行跳转 回到主页面
    @RequestMapping("/toSuccess")
    public String toSuccess(){
        return "article/success";
    }
    // 照片回显
    @RequestMapping("/getImages")
    public String toDownImage(){
        return "article/getImages";
    }
    @RequestMapping("/getInformation")
    public String downImage(HttpServletRequest request) throws Exception{
        String inPath ="http://localhost:9995/images/2018-11-27153553.png";
        System.out.println(inPath);
        request.setAttribute("imageUrl",inPath);
        return "article/getImages";
    }
    /**
     * 保存留言信息
     */
    @RequestMapping(value="/saveWords")
    public String saveWords(Words words){
        if(words != null){
            String r_id = words.getLw_for_article_id();
            articleService.saveWords(words);
            return "article/toArticleView?r_id="+r_id;
        }else{
            return null;
        }
    }

    /**
     * 保存回复信息
     */
    @RequestMapping(value="/saveReply")
    public String saveReply(Reply reply){
        if(reply != null){
            articleService.saveReply(reply);
            String r_id = reply.getLr_for_article_id();
            return "article/toArticleView?r_id="+r_id;
        }else{
            return null;
        }
    }

    /**
     * 跳转到查看文章内容页面
     */
    //声明用于存放留言回复信息的List集合
    private List<Words> lw_list;
    private List<Reply> lr_list;
    @RequestMapping(value="/toArticleView")
    public String toArticleView(@RequestParam int r_id, Model model){
        //封装留言信息
        lw_list = articleService.findByWords();
        model.addAttribute("lw_list",lw_list);

        //封装回复信息
        lr_list = articleService.findByReply();
        model.addAttribute("lr_list",lr_list);

        //查询文章信息
        Article article = articleService.findById(r_id);
        System.out.println("查询到当前文章的ID值："+article.getrId());
        if (article != null) {
            model.addAttribute("article", article);
            return "article/show";
        } else {
            return null;
        }
    }


}