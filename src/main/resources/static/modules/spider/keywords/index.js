/**
 * Created by user on 2017/7/6.
 */

$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    /* var oButtonInit = new ButtonInit();
     oButtonInit.Init(); */

    //条件查询
    $('#conditionquery').click(function(){
        $table.bootstrapTable('refresh');
    });

});

var $table = $('#bootstrapTable');

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $table.bootstrapTable({
            url: baseURL+'/spider/keywords/list',     //请求后台的URL（*）
            method: 'get',           //请求方式（*）
            classes:'table table-hover table-bordered',
            /*toolbar: '#toolbar',        //工具按钮用哪个容器
            striped: true,       */    //是否显示行间隔色
            cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,          //是否显示分页（*）
            sortable: false,           //是否启用排序
            sortOrder: "asc",          //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,            //初始化加载第一页，默认第一页
            pageSize: 20,            //每页的记录行数（*）
            pageList: [20, 50, 100],    //可供选择的每页的行数（*）
            strictSearch: false,
            clickToSelect: false,        //是否启用点击选中行
            //height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",           //每一行的唯一标识，一般为主键列
            cardView: false,          //是否显示详细视图
            detailView: false,          //是否显示父子表
            columns: [{
                field: 'checkbox',
                checkbox: true,
                align: 'center',
                valign: 'middle'
            },{
                field: 'index',
                title: '序号',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index) {
                    return index+1;
                }
            }, {
                field: 'keywords',
                title: '关键词',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'organization.name',
                title: '机构',
                align: 'center',
                valign: 'middle'
            },{
                field: 'createTime',
                title: '创建时间',
                align: 'center',
                valign: 'middle'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {

        var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageNum: params.pageNum,
            pageSize: params.pageSize,
            sort: params.sort,
            order: params.order,
            orgName:$('#form-search').find("input[name='orgName']").val(),
            keywords:$('#form-search').find("input[name='keywords']").val()
        };
       /* console.log(temp);
        console.log(JSON.stringify(temp));*/
        return temp;
    };
    return oTableInit;
};


var addParsley = $('#form-add').parsley();

function add() {
    addParsley.validate();
    if(addParsley.isValid()){
        var saveData = { organization:{
            id:$("#form-add").find("select[name='org_id'] option:selected").val(),
            name:$("#form-add").find("select[name='org_id'] option:selected").text()
        },
            keywords:$("#form-add").find("input[name='keywords']").val()
        };
        $.ajax({
            type:"POST",
            url:baseURL+"/spider/keywords/add",
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
        url:baseURL+'/spider/keywords/delete',
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


