<#-- @ftlvariable name="order" type="mvc.common.OrdersInfo" -->
<#macro order order>
<tr class="order${order.id}">
    <td>${order.creation_time}</td>
    <td>${order.status}</td>
    <td>${order.pay_type}</td>
    <td>${order.total_count} pcs</td>
    <td>$${order.total_sum}</td>
    <td class="delete_order" id="${order.id}"  data-id="${order.id}">X</td>
</tr>
</#macro>