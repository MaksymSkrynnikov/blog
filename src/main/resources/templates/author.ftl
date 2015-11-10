<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>author</title>
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
<body>

<#list authors as author>
<div class="panel panel-default">
    <p <#--class="bg-primary"-->>
        Author name: ${author.name} (Registered: ${author.registrationDate})<br/>
        Login: ${author.login}
    </p>
    <#list author.blogs as blog>
        <div class="panel-body">
            <div class="alert alert-info" role="banner"><a href="<@spring.url '/blog/'/>${blog.id}">${blog.title}</a>
            </div>
            (Creation date: ${blog.creationMoment})<br/>
            Comments amount ${blog.comments?size}
        </div>
    </#list>
</div>
</#list>
</body>
</html>