<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
    <head>
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
        <a href="<@spring.url '/author/'/>">All authors</a>
        <div>
            <h2>Now available number of posts: <span class="label label-default">${blogs?size}</span></h2>
            <#list blogs as blog>
                <div class="panel panel-default">
                    <div class="alert alert-info" role="banner"><a href="<@spring.url '/blog/'/>${blog.id}">${blog.title}</a></div>
                    <div class="panel-body">
                        <strong>Author: ${blog.authorName}</strong>
                        <strong>Registered: ${blog.authorRegistrationMoment}</strong>
                        <strong>Creation date: ${blog.creationMoment}</strong>
                        <p>Comments: ${blog.comments?size}</p>
                    </div>
                </div>
            </#list>
        </div>
    </body>
</html>

