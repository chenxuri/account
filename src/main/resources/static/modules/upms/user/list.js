var $table = $('#table');

//条件查询
$('#conditionquery').click(function(){
    $table.bootstrapTable('refresh');
});

var addParsley = $('#form-add').parsley();

function add() {
    addParsley.validate();
    if(addParsley.isValid()){
        $.post("/account/upms/user/add",
            {
                name:$("#form-add").find("input[name='name']").val(),
                enName:$("#form-add").find("input[name='enName']").val(),
                code:$("#form-add").find("input[name='code']").val(),
                website:$("#form-add").find("input[name='website']").val(),
                phone:$("#form-add").find("input[name='phone']").val(),
                email:$("#form-add").find("input[name='email']").val()
            },
            function(data){
                if(data == '1'){
                    alert("添加成功");
                    $table.bootstrapTable('refresh');
                    $("#modal-add").modal("hide");
                    addParsley.reset()
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
        url:'/account/upms/user/delete',
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
