<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<title>welcome</title>
</html>
<body>
<div>
    <h1>Now available ${blogs?size}</h1>
    <#list blogs as blog>
        <a href="<@spring.url '/blog/'/>${blog.id}">Blog: ${blog.title}</a>
        <div>
            <strong>Author: ${blog.author.name}</strong>
            <strong>Creation date: ${blog.creationMoment}</strong>
            <p>Comments: ${blog.comments?size}</p>
        </div>
    </#list>
</div>
</body>

