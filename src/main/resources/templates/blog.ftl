<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
<title>blog</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('#comment').submit(function() {
            var data = $('#comment').serialize();
            var uri = $('#comment').attr("action");
            $.ajax({
                url: uri,
                data: data,
                dataType: 'application/json',
                type: 'POST',
                async: false,
                success: function(data) {
                    alert('success');
                },
                error: function(data) {
                    alert("error");
                }
            });
            return false;
        });
    });
</script>
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
    <form name="comment" method="post" action="<@spring.url '/blog/'/> + ${blog.id} + /comment/">
        <input type="text" name="text">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
