<#-- @ftlvariable name="user" type="mvc.common.UsersInfo" -->
<#macro user user>
    <tr class="user${user.id}">
        <td>${user.login}</td>
        <td>${user.name}</td>
        <td>
            <select name="role" id="role${user.id}">
                <#--<option value="${user.role}" disabled>${user.role}</option>-->
                <option value="ROLE_USER">ROLE_USER</option>
                <option value="ROLE_ADMIN">ROLE_ADMIN</option>
            </select>
            <script>
                $('#role${user.id}').val('${user.role}');
            </script>
        </td>
        <td>${user.email}</td>
        <td class="deactivate" id="active${user.id}" data-id="${user.id}">${user.active?string("yes","no")}</td>
        <td class="update_user" id="${user.id}" data-id="${user.id}">update</td>
        <td class="delete_user" id="${user.id}" data-id="${user.id}">X</td>
    </tr>
</#macro>