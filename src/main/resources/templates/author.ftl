<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>author</title>
    </head>
    <body>
        <div>
        <#list authors as author>
            <p>Author name: ${author.name} (Registered: ${author.registrationDate})</p>
            <#--<p>Login: ${author.login}</p>-->
            <#list author.blogs as blog>
                Blog ${blog.title}
                Date ${blog.creationMoment}
                Text ${blog.text}
                <#list blog.comments as comment>
                    <p>Owner name: ${comment.ownerName} (Created: ${comment.creationMoment})</p>
                    <p>${comment.text}</p>
                </#list>
            </#list>
        </#list>
        </div>
    </body>
</html>