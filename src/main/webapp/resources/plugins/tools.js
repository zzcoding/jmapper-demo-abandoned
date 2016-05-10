/**
 * 
 */

var Tools={
	
  stopPop:function(event){
		

		      var e=event || window.event;
		      if (e && e.stopPropagation){
		            e.stopPropagation();    
		       }else{
		            e.cancelBubble=true;
		      }

  }
}

$.validator.addMethod("spchar", function(value, element) {  
	  return this.optional(element) || !(/[<>?~!@^#$%&\*]/.test(value));  
	}, "文本内容中有特殊字符!");  
$.validator.addMethod("password-rule", function(value, element) {  
	  return this.optional(element) || (/^(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*$/.test(value));  
	}, "密码为数字和小写字母组合!");  
$.validator.addMethod("numorletter", function(value, element) {  
	  return this.optional(element) || (/^[a-zA-Z0-9]*$/.test(value));  
	}, "该域输入规则为数字或字母!"); 
$(function(){
	$("input.trim").bind("keyup blur",function(){
		$(this).val($.trim($(this).val()));
	});
	$("form").bind('submit',function(){
		$("input.trim").each(function(){
			$(this).val($.trim($(this).val()));
		});
	});
	$(".bgtable").attr("border","0");
	$(".bgtable").attr("cellpadding","0");
	$(".bgtable").attr("cellspacing","0");
	$(".bgtable").find("tr").each(function(index ,item){
		$(this).attr("height","30");
	/*	 if(index ==0){
			 $(this).find("td").attr("bgcolor","#e1e5ee");
			 $(this).find("td").attr("align","left");
			 $(this).find("td").css("font-weight","bold");
			 $(this).find("td").css("padding-left","10px");
			 $(this).find("td").css("color","#333333");
		 }else{*/
			 if( index!=0 && index%2==0 )
				 $(this).attr("bgcolor","#f2f2f2");
			 else
				 $(this).attr("bgcolor","#F7F8F9");
			 /*}*/
		
		
	});
	
	$.validator.setDefaults({
		 errorPlacement: function(error, element) {  
			    if($(element).is("select"))
			    	$(element).next(".btn-group").after(error);
			    else{
			    	$(element).after(error).after("<br>");
			    }
			    	
		    } ,
		    ignore:"",
		    messages: {
		    		required: "该字段不能为空！",
		    		remote: "Please fix this field.",
		    		email: "请输入正确的邮箱格式！",
		    		url: "Please enter a valid URL.",
		    		date: "Please enter a valid date.",
		    		dateISO: "Please enter a valid date ( ISO ).",
		    		number: "Please enter a valid number.",
		    		digits: "Please enter only digits.",
		    		creditcard: "Please enter a valid credit card number.",
		    		equalTo: "Please enter the same value again.",
		    		maxlength: $.validator.format( "Please enter no more than {0} characters." ),
		    		minlength: $.validator.format( "Please enter at least {0} characters." ),
		    		rangelength: $.validator.format( "Please enter a value between {0} and {1} characters long." ),
		    		range: $.validator.format( "Please enter a value between {0} and {1}." ),
		    		max: $.validator.format( "Please enter a value less than or equal to {0}." ),
		    		min: $.validator.format( "Please enter a value greater than or equal to {0}." )
		    	},
	});
	

});
(function($){  
    //备份jquery的ajax方法  
    var _ajax=$.ajax;  
      
    //重写jquery的ajax方法  
    $.ajax=function(opt){  
        //备份opt中error和success方法  
        var fn = {  
            error:function(XMLHttpRequest, textStatus, errorThrown){},  
            success:function(data, textStatus){}  
        }  
        if(opt.error){  
            fn.error=opt.error;  
        }  
        if(opt.success){  
            fn.success=opt.success;  
        }  
          
        //扩展增强处理  
        var _opt = $.extend(opt,{  
            error:function(XMLHttpRequest, textStatus, errorThrown){  
                //错误方法增强处理  
            	  alert("error:"+data)
                fn.error(XMLHttpRequest, textStatus, errorThrown);  
            },  
            success:function(data, textStatus){  
                //成功回调方法增强处理  

                if(data && typeof data=='string'){
                	
                	var result;
                	
                	try{
                		var result=$.parseJSON(data);
                	}catch(e){
                		fn.success(data, textStatus); 
                	}
                	
                	if(result&&result.ajax){
                		alert(result.msg);
                		if(result.msg.indexOf('失效')>=0)
                		window.location="login"
                		return;
                	}else if(result&&result.error){
                		alert(result.msg);
                		return;
                	}else{
                		fn.success(data, textStatus);  
                	}
                }else{
                	if(data&&data.ajax){
                		alert(data.msg);
                		return;
                	}else if(data&&data.error){
                		alert(data.msg);
                		return;
                	}else{
                	    fn.success(data, textStatus);
                	}
                }
            
            }  
        });  
       return  _ajax(_opt);  
    };  


})(jQuery);


$.extend({
    
    /**
     * 将数值四舍五入(保留1位小数)后格式化成金额形式
     *
     * @param num 数值(Number或者String)
     * @return 金额格式的字符串,如'1,234,567.4'
     * @type String
     */
	   formatCurrencyTenThou:function(num){
		    num = num.toString().replace(/\$|\,/g,'');
	        if(isNaN(num))
	        num = "0";
	        sign = (num == (num = Math.abs(num)));
	        num = Math.floor(num*10+0.50000000001);
	        cents = num%10;
	        num = Math.floor(num/10).toString();
	        for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
	        num = num.substring(0,num.length-(4*i+3))+','+
	        num.substring(num.length-(4*i+3));
	        return (((sign)?'':'-') + num + '.' + cents);
	   },
	    /**
	     * 将数值四舍五入(保留2位小数)后格式化成金额形式
	     *
	     * @param num 数值(Number或者String)
	     * @return 金额格式的字符串,如'1,234,567.45'
	     * @type String
	     */
	   formatCurrency:function(num){
		    num = num.toString().replace(/\$|\,/g,'');
	        if(isNaN(num))
	        num = "0";
	        sign = (num == (num = Math.abs(num)));
	        num = Math.floor(num*100+0.50000000001);
	        cents = num%100;
	        num = Math.floor(num/100).toString();
	        if(cents<10)
	        cents = "0" + cents;
	        for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
	        num = num.substring(0,num.length-(4*i+3))+','+
	        num.substring(num.length-(4*i+3));
	        return (((sign)?'':'-') + num + '.' + cents);
	   },
	   getMultiSelectedValuesArray : function(select){
	    	var vals=[];
	    	select.find("option").each(function(){
	    		if(this.selected)
	    			vals.push(this.value);
	    	});
	    	return vals;
	    },
	    loadSelect:function(jqObj,url,opt){
	    	 var defaults={
	    			 defaultNonSelected:{id:'',text:'全部'}
	    	 }
	    	 opt = $.extend(defaults, opt);
	    	 $.post(url,opt,function(results){
	    		    results.unshift(opt.defaultNonSelected);
	    		    jqObj.select2({
	    	 			data:results
	    	 		});
	    	 });
	    },
	    getMultiSelectedValueStr : function(select,sep){
	    	var vals='';
	    	select.find("option").each(function(){
	    		if(this.selected){
	    			if(vals=='')
	    				vals = "'"+this.value+"'";
	    			else 
	    				vals=vals+sep+"'"+this.value+"'";
	    		}
	    			
	    	});
	    	return vals;
	    },
	    getFormParams :function(fm){
			params={};
			if(fm){	
				var formParam=fm.serializeArray();
				$.each(formParam, function(i, field){
					    params[field.name]=field.value;
					
				 }); 
			}
			return params;
  
	    }
	});

jQuery(window).load(function() {

	   "use strict";
	   jQuery('#preloader').delay(100).fadeOut(function(){
	      jQuery('body').delay(100).css({'overflow':'visible'});
	   });
	});