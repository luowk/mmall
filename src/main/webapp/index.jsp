<!DOCTYPE html>
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

    springmvc上传文件
    <form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
        <input name="uploadFile" type="file"/>
        <input type="submit" value="springmvc上传文件" />
    </form>

    richtext上传文件
    <form name="form2" action="/manage/product/richtextImgUpload.do" method="post" enctype="multipart/form-data">
        <input name="uploadFile" type="file"/>
        <input type="submit" value="richtext上传文件"/>
    </form>
</body>
</html>
