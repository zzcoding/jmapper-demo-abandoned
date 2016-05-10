var mmg;
$(document).ready(function(){

 	/*$('#realname').select2({
 		 ajax: {
 		    url: 'demo/api',
 		    delay: 250,
 		    cache: true
 		  }
 	  });*/
 	 $.post('demo/api',{},function(results){

 		$('#realname').select2({
 			data:results.results
 		});
 	 });
 	 function formatRepo (repo) {
 	      if (repo.loading) return repo.text;

 	      var markup = "<div class='select2-result-repository clearfix'>" +
 	        "<div class='select2-result-repository__avatar'><img src='" + repo.owner.avatar_url + "' /></div>" +
 	        "<div class='select2-result-repository__meta'>" +
 	          "<div class='select2-result-repository__title'>" + repo.full_name + "</div>";

 	      if (repo.description) {
 	        markup += "<div class='select2-result-repository__description'>" + repo.description + "</div>";
 	      }

 	      markup += "<div class='select2-result-repository__statistics'>" +
 	        "<div class='select2-result-repository__forks'><i class='fa fa-flash'></i> " + repo.forks_count + " Forks</div>" +
 	        "<div class='select2-result-repository__stargazers'><i class='fa fa-star'></i> " + repo.stargazers_count + " Stars</div>" +
 	        "<div class='select2-result-repository__watchers'><i class='fa fa-eye'></i> " + repo.watchers_count + " Watchers</div>" +
 	      "</div>" +
 	      "</div></div>";

 	      return markup;
 	    }

 	    function formatRepoSelection (repo) {
 	      return repo.full_name || repo.text;
 	    }

    //表头分组
    var groupCols = [
        {title:'序号', name:'', width: 30, align: 'center',  renderer: function(val,item,rowIndex){
            return rowIndex+1;
        }},
       
            { title:'用户名', name:'username' ,width:100, align:'left' ,sortable: true},
            { title:'用户真实姓名', name:'realname' ,width:100, align:'left' ,sortable: true},
       
        { title:'电话号码', name:'tel' ,width:60, align:'left' ,sortable: true},
        { title:'电子邮箱', name:'email' ,width:120, align:'left' ,sortable: true},
        { title:'网站地址', name:'url' ,width:120, align:'left' ,sortable: true},
        { title:'备案编码', name:'code' ,width:60, align:'left' ,sortable: true},
      
        { title:'qq号码', name:'qq' ,width:70, align:'left' },
        { title:'qq2号码', name:'qq2' ,width:70, align:'left' },
        
        { title:'通知消息', name:'notice' ,width:80, align:'left' },
        { title:'关键字', name:'keyword',width:80, align:'left' ,sortable: true},
        { title:'创建时间', name:'creatTime' ,width:70, align:'left' ,sortable: true}
        
    ];
    mmg = $('#table12-1').mmGrid({
        cols: groupCols
        ,height:'auto'
        ,url: 'demo/list'
        ,method: 'post'
        ,remoteSort:false
        ,multiSelect: false
        ,checkCol: false
        ,fullWidthRows: true
        ,autoLoad: true
        ,nowrap:true
        ,plugins: [
            $('#pg').mmPaginator({})
         ]
        ,params: function(){
             return $.getFormParams($('#fm'));
        }
    });
});
function query(){
	mmg.load($.getFormParams($("#fm")));
}