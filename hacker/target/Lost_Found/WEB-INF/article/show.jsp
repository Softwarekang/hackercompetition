<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 侯景瀚
  Date: 2018/11/28
  Time: 12:56
  此页面位详情页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>详情</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String nowDate = sdf.format(date);
    %>
</head>
<style type="text/css">
    .back{
        color:red;
        position:absolute;
        top:20px;
        left:1400px;
        font-size:14px;
    }
</style>
<body bgcolor="#BFEFFF">
<div class="back"><input type="button" value="点此返回主页面" onclick="window.location.href='/article/listAll.action?id=${userId}'" ></div>
<table bgcolor="#7fffd4">
    <tr>
        <td>作者：</td>
        <td>${article.rAuthor}</td>
    </tr>
    <tr>
        <td>分类：</td>
        <td>${article.rSort}</td>
    </tr>
    <tr>
        <td>日期：</td>
        <td>${article.rDate}</td>
    </tr>
    <tr>
        <td>描述：</td>
        <td>${article.rContent}</td>
    </tr>
    <tr>

    <img src="${article.rImage}" width="180px" height="182px">
    </tr>
</table>

<script src="<%=basePath%>/static/js/jquery-3.3.1.min.js"></script>
<div style="margin:0 4% 0 4%;">
    <br/>
    <!-- 留言的表单 -->
    <form class="layui-form" action="<%=basePath%>/article/saveWords.action?id=${userId}" method="post">
        <input name="lw_name" value="${sessionScope.username}" hidden="hidden"/>
        <input name="lw_date" value="<%=nowDate%>" hidden="hidden"/>
        <input name="lw_for_name" value="${article.rAuthor}" hidden="hidden"/>
        <input name="lw_for_article_id" value="${article.rId}" hidden="hidden"/>
        <div class="layui-input-block" style="margin-left: 0;">
            <textarea id="lw_content" name="lw_content" placeholder="请输入你的留言" class="layui-textarea" rows="3" cols="50"></textarea>
        </div>
        <br/>
        <div class="layui-input-block" style="text-align: left;margin-left: 0;">
            <input type="submit" class="layui-btn" value="留言">
        </div>
    </form>
    <br/>
    <!-- 留言信息列表展示 -->
    <div>
        <ul>
            <!-- 先遍历留言信息（一条留言信息，下面的全是回复信息） -->
            <c:forEach items="${wordsList}" var="words">
                <!-- 如果留言信息是在本文章下的才显示 -->
                <c:if test="${words.lw_for_article_id eq article.rId}">
                    <li style="border-top: 1px dotted #01AAED">
                        <br/>
                        <div style="text-align: left;color:#444">
                            <div>
                                <span style="color:#01AAED">${words.lw_name}</span>
                            </div>
                            <div>${words.lw_content}</div>
                        </div>
                        <div>
                            <div class="comment-parent" style="text-align:left;margin-top:7px;color:#444">
                                <span>${words.lw_date}</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <p>
                                    <a href="javascript:;" style="text-decoration: none;" onclick="btnReplyClick(this)">回复</a>
                                </p>
                                <hr style="margin-top: 7px;"/>
                            </div>
                            <!-- 回复表单默认隐藏 -->
                            <div class="replycontainer layui-hide" style="margin-left: 61px;">
                                <form action="<%=basePath%>/article/saveReply.action?id=${userId}" method="post" class="layui-form">
                                    <input name="lr_for_article_id" id="lr_for_article_id" value="${article.rId}" hidden="hidden"/>
                                    <input name="lr_name" id="lr_name" value="${sessionScope.username}" hidden="hidden"/>
                                    <input name="lr_date" id="lr_date" value="<%=nowDate%>" hidden="hidden"/>
                                    <input name="lr_for_name" id="lr_for_name" value="${words.lw_name}" hidden="hidden"/>
                                    <input name="lr_for_words" id="lr_for_words" value="${words.lw_id}" hidden="hidden"/>
                                    <input name="lr_for_reply" id="lr_for_reply" value="${reply.lr_id}" hidden="hidden"/>
                                    <div class="layui-form-item">
                                        <textarea name="lr_content" id="lr_content" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" rows="3" cols="50""></textarea>
                                    </div>
                                    <div class="layui-form-item">
                                        <input type="submit" class="layui-btn" value="回复">
                                    </div>
                                </form>
                            </div>
                        </div>

                        <!-- 以下是回复信息 -->
                        <c:forEach items="${replyList}" var="reply">
                            <!-- 每次遍历出来的留言下存在回复信息才展示（本条回复信息是本条留言下的就显示在当前留言下） -->
                            <c:if test="${reply.lr_for_article_id eq article.rId && reply.lr_for_words eq words.lw_id}">
                                <div style="text-align: left;margin-left:61px;color: #444">
                                    <div>
                                        <span style="color:#5FB878">${reply.lr_name}&nbsp;&nbsp;</span>
                                    </div>
                                    <div style="color: #666">@${reply.lr_for_name}:</div>
                                    <div>&nbsp;&nbsp; ${reply.lr_content}</div>
                                </div>
                                <div>
                                    <div class="comment-parent" style="text-align:left;margin-top:7px;margin-left:61px;color:#444">
                                        <span>${reply.lr_date}</span>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <p>
                                            <a href="javascript:;" style="text-decoration: none;" onclick="btnReplyClick(this)">回复</a>
                                        </p>
                                        <hr style="margin-top: 7px;"/>
                                    </div>
                                    <!-- 回复表单默认隐藏 -->
                                    <div class="replycontainer layui-hide" style="margin-left: 61px;">
                                        <form action="<%=basePath%>/article/saveReply.action?id=${userId}" method="post" class="layui-form">
                                            <input name="lr_for_article_id" id="lr_for_article_id" value="${article.rId}" hidden="hidden"/>
                                            <input name="lr_name" id="lr_name" value="${sessionScope.username}" hidden="hidden"/>
                                            <input name="lr_date" id="lr_date" value="<%=nowDate%>" hidden="hidden"/>
                                            <input name="lr_for_name" id="lr_for_name" value="${words.lw_name}" hidden="hidden"/>
                                            <input name="lr_for_words" id="lr_for_words" value="${words.lw_id}" hidden="hidden"/>
                                            <input name="lr_for_reply" id="lr_for_reply" value="${reply.lr_id}" hidden="hidden"/>
                                            <div class="layui-form-item">
                                                <textarea name="lr_content" id="lr_content" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" rows="3" cols="50"></textarea>
                                            </div>
                                            <div class="layui-form-item">
                                                    <%--<button id="replyBtn" class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>--%>
                                                <input type="submit" class="layui-btn" value="回复">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
</div>
