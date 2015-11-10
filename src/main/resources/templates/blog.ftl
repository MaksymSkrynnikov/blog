<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>blog</title>
        <title>welcome</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
              integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
              integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
              crossorigin="anonymous">
    </head>
    <body style="background: #D8D8D8; width: 100%; height: 100%">
        <div>
            <p class="bg-primary"><h1>${blog.title}</h1></p>
            <p>Created: ${blog.creationMoment}</p>
            <p>Author: ${blog.authorName} (registered ${blog.authorRegistrationMoment})</p>
            <p>${blog.text}</p>
            <#list blog.comments as comment>
                <div>
                    <p>Owner name: ${comment.ownerName} (Created: ${comment.creationMoment})</p>
                    <p>${comment.text}</p>
                </div>
            </#list>
            <form name="comment" action="<@spring.url '/blog/'/>${blog.id}/comment/" method="post">
                <input type="text" name="ownerName" placeholder="Your name..."><br/>
                <input width="300" height="400" type="text" name="text" placeholder="Your comment..."><br/>
                <input type="submit" value="Submit" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>