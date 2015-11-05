<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>blog</title>
    </head>
    <body>
        <div>
            <h1>${blog.title}</h1>
            <p>Created: ${blog.creationMoment}</p>
            <p>Author: ${blog.authorName} (registered ${blog.authorRegistrationMoment})</p>
            <p>${blog.text}</p>
            <#list blog.comments as comment>
                <p>Owner name: ${comment.ownerName} (Created: ${comment.creationMoment})</p>
                <p>${comment.text}</p>
            </#list>
            <form name="comment" action="<@spring.url '/blog/'/>${blog.id}/comment/" method="post">
                Your name: <input type="text" name="ownerName">
                Your comment: <input type="text" name="text">
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>