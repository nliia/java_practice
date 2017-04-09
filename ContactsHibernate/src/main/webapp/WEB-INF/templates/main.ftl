<center>

    <a href="/contact">New contact</a>
<#if result ??>
    <h4>${result}</h4>
</#if>
<#if contacts ??>
    <#list contacts as con>
        <table border="3" width="40%">
            <tr>
                <td>${con.id}</td>
                <td>${con.name}</td>
                <td>${con.email}</td>
                <td>${con.address}</td>
                <td>
                    <form action="/delete" method="post">
                        <input type="hidden" name="id" value="${con.id}">
                        <input type="submit" value="Delete">
                    </form>
                    <form action="/edit" method="get">
                        <input type="hidden" name="id" value="${con.id}">
                        <input type="submit" value="Edit">
                    </form>

                </td>
            </tr>
        </table>

    </#list>

</#if>
</center>