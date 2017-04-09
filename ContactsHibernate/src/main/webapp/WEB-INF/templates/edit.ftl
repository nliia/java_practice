<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<h4>Edit contact:</h4>
<#if result ??>
<h4>${result}</h4>
</#if>
<@sf.form role="form" action='/edit' method="post" modelAttribute="contact">
<fieldset>
    <#if id ??>
        <@sf.input path="id" type="hidden" value="${id}"/>
    </#if>

    <div class="field">
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="name" required="required"/>
        <@sf.errors path="name" />
    </div>

    <div class="field">
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" type="email" required="required"/>
        <@sf.errors path="email"/>
    </div>

    <div class="field">
        <@sf.label path="address">Address</@sf.label>
        <@sf.input path="address" type="text" required="required"/>
        <@sf.errors path="address"/>
    </div>
    <input type="submit" value="Edit">
</fieldset>
</@sf.form>