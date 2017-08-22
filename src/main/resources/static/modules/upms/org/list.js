var $table = $('#table');

//条件查询
$('#conditionquery').click(function(){
    $table.bootstrapTable('refresh');
});

var addParsley = $('#form-add').parsley();

function add() {
    addParsley.validate();
    if(addParsley.isValid()){

        var saveData = {
            name:$("#form-add").find("input[name='name']").val(),
            enName:$("#form-add").find("input[name='enName']").val(),
            code:$("#form-add").find("input[name='code']").val(),
            website:$("#form-add").find("input[name='website']").val(),
            phone:$("#form-add").find("input[name='phone']").val(),
            email:$("#form-add").find("input[name='email']").val(),
            address:$("#form-add").find("input[name='address']").val(),
            remarks:$("#form-add").find("textarea[name='remarks']").val(),
            master:{
                id:$("#form-add").find("select[name='master_id'] option:selected").val(),
                name:$("#form-add").find("select[name='master_id'] option:selected").text()
            }
        };

        $.ajax({
            type:"POST",
            url:baseURL+"/upms/org/add",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(saveData),
            success:function(data){
                if(data == '1'){
                    alert("添加成功");
                    $table.bootstrapTable('refresh');
                    $("#modal-add").modal("hide");
                    addParsley.reset()
                }else {
                    alert("添加失败");
                }

            }
        });
    }
    //
}

var records;

function remove() {
    records = $table.bootstrapTable('getSelections');
    if(records.length < 1){
        alert("请选择至少一条数据！");
        return;
    }
    var idAr = [];
    //console.log(records);
    for(var i=0;i<records.length;i++){
        idAr.push(records[i].id);
    }
    //console.log(idAr);
    $.ajax({
        type:'post',
        traditional :true,
        url:'/account/upms/org/delete',
        data:{ids:idAr},
        success:function(data){
            if(data == '1'){
                alert("删除成功");
                $table.bootstrapTable('refresh');
            }else {
                alert("删除失败");
            }
        }
    });
}



/**
 * Created by user on 2017/7/4.
 */
