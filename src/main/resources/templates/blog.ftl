<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html>
<title>blog</title>
</html>
<body>
<div>
    <h1>${blog.title}</h1>
    <p>Created: ${blog.creationMoment}</p>
    <p>Author: ${blog.author.name} (registered ${blog.author.registrationDate})</p>
    <p>${blog.text}</p>
    <#list blog.comments as comment>
        <p>Created: ${comment.creationMoment}</p>
        <p>${comment.text}</p>
    </#list>
    <form method="post" action="<@spring.url '/blog/'/> + ${blog.id} + /comment/">
        <input type="text">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
