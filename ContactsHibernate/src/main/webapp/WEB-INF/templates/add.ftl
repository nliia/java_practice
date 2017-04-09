<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<h4>Add contact:</h4>
<#if result ??>
<h4>${result}</h4>
</#if>
<@sf.form role="form" action='/new_contact' method="post" modelAttribute="contact">
<fieldset>
    <div class="field">
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="name"/>
        <@sf.errors path="name" />
    </div>
    <div class="field">
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" type="email"/>
        <@sf.errors path="email"/>
    </div>
    <div class="field">
        <@sf.label path="address">Address</@sf.label>
        <@sf.input path="address" type="text"/>
        <@sf.errors path="address"/>
    </div>
        <input type="submit" value="Add">
</fieldset>
</@sf.form>