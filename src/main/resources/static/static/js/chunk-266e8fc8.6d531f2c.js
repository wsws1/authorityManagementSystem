(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-266e8fc8"],{1004:function(e,t,o){},"1aba":function(e,t,o){"use strict";var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"material-input__component",class:e.computedClasses},[o("div",{class:{iconClass:e.icon}},[e.icon?o("i",{staticClass:"el-input__icon material-input__icon",class:["el-icon-"+e.icon]}):e._e(),e._v(" "),"email"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"email"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"url"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"url"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"number"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,step:e.step,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,max:e.max,min:e.min,minlength:e.minlength,maxlength:e.maxlength,required:e.required,type:"number"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"password"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,max:e.max,min:e.min,required:e.required,type:"password"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"tel"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,required:e.required,type:"tel"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),"text"===e.type?o("input",{directives:[{name:"model",rawName:"v-model",value:e.currentValue,expression:"currentValue"}],staticClass:"material-input",attrs:{name:e.name,placeholder:e.fillPlaceHolder,readonly:e.readonly,disabled:e.disabled,autocomplete:e.autoComplete,minlength:e.minlength,maxlength:e.maxlength,required:e.required,type:"text"},domProps:{value:e.currentValue},on:{focus:e.handleMdFocus,blur:e.handleMdBlur,input:[function(t){t.target.composing||(e.currentValue=t.target.value)},e.handleModelInput]}}):e._e(),e._v(" "),o("span",{staticClass:"material-input-bar"}),e._v(" "),o("label",{staticClass:"material-label"},[e._t("default")],2)])])},n=[],l=(o("c5f6"),{name:"MdInput",props:{icon:String,name:String,type:{type:String,default:"text"},value:[String,Number],placeholder:String,readonly:Boolean,disabled:Boolean,min:String,max:String,step:String,minlength:Number,maxlength:Number,required:{type:Boolean,default:!0},autoComplete:{type:String,default:"off"},validateEvent:{type:Boolean,default:!0}},data:function(){return{currentValue:this.value,focus:!1,fillPlaceHolder:null}},computed:{computedClasses:function(){return{"material--active":this.focus,"material--disabled":this.disabled,"material--raised":Boolean(this.focus||this.currentValue)}}},watch:{value:function(e){this.currentValue=e}},methods:{handleModelInput:function(e){var t=e.target.value;this.$emit("input",t),"ElFormItem"===this.$parent.$options.componentName&&this.validateEvent&&this.$parent.$emit("el.form.change",[t]),this.$emit("change",t)},handleMdFocus:function(e){this.focus=!0,this.$emit("focus",e),this.placeholder&&""!==this.placeholder&&(this.fillPlaceHolder=this.placeholder)},handleMdBlur:function(e){this.focus=!1,this.$emit("blur",e),this.fillPlaceHolder=null,"ElFormItem"===this.$parent.$options.componentName&&this.validateEvent&&this.$parent.$emit("el.form.blur",[this.currentValue])}}}),i=l,r=(o("49b7"),o("2877")),s=Object(r["a"])(i,a,n,!1,null,"9d7baaf6",null);t["a"]=s.exports},"49b7":function(e,t,o){"use strict";var a=o("1004"),n=o.n(a);n.a},9493:function(e,t,o){},"9f91":function(e,t,o){"use strict";o.r(t);var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-form",{ref:"postForm",attrs:{"label-position":e.labelPosition,model:e.postForm,rules:e.rules}},[o("sticky",[o("div",{class:"sub-navbar "+e.postForm.status},[e.isEdit?e._e():o("el-button",{on:{click:e.showGuide}},[e._v("显示帮助")]),e._v(" "),o("el-button",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{"margin-left":"10px"},attrs:{type:"success"},on:{click:e.submitForm}},[e._v("\n        "+e._s(e.isEdit?"编辑菜单":"新增菜单")+"\n       ")])],1)]),e._v(" "),o("div",{staticClass:"detail-container"},[o("el-row",[o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{prop:"title"}},[o("Mdinput",{attrs:{maxlength:100,name:"title",required:""},model:{value:e.postForm.title,callback:function(t){e.$set(e.postForm,"title",t)},expression:"postForm.title"}},[e._t("default",[e._v("菜单标题")])],2)],1),e._v(" "),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"name",label:"组件名称: ","label-width":"80px"}},[o("el-input",{attrs:{placeholder:"组件名称"},model:{value:e.postForm.name,callback:function(t){e.$set(e.postForm,"name",t)},expression:"postForm.name"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"path",label:"路由: ","label-width":"80px"}},[o("el-input",{attrs:{placeholder:"路由"},model:{value:e.postForm.path,callback:function(t){e.$set(e.postForm,"path",t)},expression:"postForm.path"}},[o("template",{slot:"prepend"},[e._v("Http://")])],2)],1)],1)],1),e._v(" "),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"component",label:"组件路径: ","label-width":"80px"}},[o("el-input",{attrs:{placeholder:"组件路径"},model:{value:e.postForm.component,callback:function(t){e.$set(e.postForm,"component",t)},expression:"postForm.component"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"hidden",label:"是否隐藏: ","label-width":"80px"}},[o("el-switch",{attrs:{placeholder:"是否隐藏"},model:{value:e.postForm.hidden,callback:function(t){e.$set(e.postForm,"hidden",t)},expression:"postForm.hidden"}})],1)],1)],1),e._v(" "),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"type",label:"类型: ","label-width":"80px"}},[o("div",{staticStyle:{"margin-top":"20px"}},[o("el-radio",{attrs:{label:0,border:"",size:"medium"},model:{value:e.postForm.type,callback:function(t){e.$set(e.postForm,"type",t)},expression:"postForm.type"}},[e._v("导航栏")]),e._v(" "),o("el-radio",{attrs:{label:1,border:"",size:"medium"},model:{value:e.postForm.type,callback:function(t){e.$set(e.postForm,"type",t)},expression:"postForm.type"}},[e._v("按钮")])],1)])],1),e._v(" "),1==e.postForm.type?o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"permission",label:"权限字: ","label-width":"80px"}},[o("el-input",{attrs:{placeholder:"权限关键字"},model:{value:e.postForm.permission,callback:function(t){e.$set(e.postForm,"permission",t)},expression:"postForm.permission"}})],1)],1):e._e()],1),e._v(" "),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"过滤","label-width":"80px"}},[o("el-input",{attrs:{placeholder:"输入关键字进行过滤"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{prop:"parentMenuName",label:"父菜单: ","label-width":"80px"}},[o("el-input",{attrs:{disabled:"",placeholder:"父菜单"},model:{value:e.postForm.parentMenuName,callback:function(t){e.$set(e.postForm,"parentMenuName",t)},expression:"postForm.parentMenuName"}})],1)],1)],1),e._v(" "),o("el-row",{attrs:{gutter:20}},[o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"菜单树："}},[e.postForm.menuTree&&e.postForm.menuTree.length>0?o("div",{staticClass:"contents-wrapper"},[o("el-tree",{ref:"tree",staticClass:"filter-tree",attrs:{"default-checked-keys":[e.postForm.parentUuid],"check-strictly":"","show-checkbox":"","highlight-current":"",data:e.postForm.menuTree,"node-key":"menuUuid",props:e.defaultProps,"default-expand-all":"","filter-node-method":e.filterNode},on:{check:e.handleCheckChange}})],1):o("span",[e._v("无")])])],1)],1)],1)],1)],1)],1)},n=[],l=(o("8e6e"),o("7f7f"),o("ac6a"),o("456d"),o("bd86")),i=o("75fc"),r=o("1f27"),s=o("1aba"),u=o("fb1f"),c=o("b804"),d=o("f3d1");function p(e,t){var o=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),o.push.apply(o,a)}return o}function m(e){for(var t=1;t<arguments.length;t++){var o=null!=arguments[t]?arguments[t]:{};t%2?p(Object(o),!0).forEach((function(t){Object(l["a"])(e,t,o[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(o)):p(Object(o)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(o,t))}))}return e}var h="http://localhost:8082",f={title:"菜单标题",name:"组件名称",resUrl:"菜单Url",parentUuid:"父菜单",accountCode:"开户账号"},v={menuUuid:"",title:"",name:"",path:"",hidden:0,component:"",permission:"",parentUuid:"",type:0,menuTree:[]},b={components:{Sticky:c["a"],Warning:d["default"],EbookUpload:u["a"],Mdinput:s["a"]},props:{isEdit:Boolean},watch:{filterText:function(e){this.$refs.tree.filter(e)}},data:function(){var e=function(e,t,o){null==t||0===t.length?o(new Error(f[e.field]+"必须填写")):o()};return{filterText:"",loading:!1,defaultProps:{children:"children",label:"title"},defaultSelected:[],postForm:{menuUuid:"",title:"",name:"",path:"",hidden:0,parentMenuName:"",component:"",permission:"",parentUuid:"",type:0,menuTree:[]},labelPosition:"left",rules:{title:[{validator:e}],parentUuid:[{validator:e}],resUrl:[{validator:e}]}}},created:function(){if(this.getMenuTree(),this.isEdit){console.log("编辑");var e=this.$route.params.menuId;this.postForm.menuUuid=e,console.log(e),this.getMenuData(e)}},computed:{getCompleteUrl:function(){return function(e){return"".concat(h,"/").concat(e)}}},methods:{getMenuTree:function(){var e=this;Object(r["f"])().then((function(t){var o=Object(i["a"])(t.data),a=m(m({},e.postForm),{},{menuTree:o});e.postForm=Object.assign({},e.postForm,a)}))},filterNode:function(e,t){return console.log(t),!e||-1!==t.title.indexOf(e)},getMenuData:function(e){var t=this;Object(r["d"])(e).then((function(e){t.setData(e.data)}))},showGuide:function(){console.log("guide")},submitForm:function(){var e=this,t=function(t){var o=t.msg;e.$notify({title:"操作成功",message:o,type:"success",duration:2e3}),e.getMenuTree(),e.loading=!1};console.log(this.postForm),this.loading||(this.loading=!0,this.$refs.postForm.validate((function(o,a){if(console.log(o),o)console.log("vaild success"),e.isEdit?Object(r["g"])(e.postForm).then((function(e){t(e)})):Object(r["b"])(e.postForm).then((function(e){t(e)})),e.loading=!1;else{var n=a[Object.keys(a)[0]][0].message;console.log(n),e.$message({message:n,type:"error"}),e.loading=!1}})))},setData:function(e){console.log(e);var t=e.menuUuid,o=e.title,a=e.name,n=e.path,l=e.hidden,i=e.component,r=e.permission,s=e.parentUuid,u=e.type;this.postForm=m(m({},this.postForm),{},{menuUuid:t,title:o,name:a,path:n,hidden:l,component:i,permission:r,parentUuid:s,type:u}),console.log(this.postForm)},onUploadSuccess:function(e){console.log(e),console.log("onUploadSuccess"),this.setData(e)},toDefault:function(){this.postForm=Object.assign({},v),this.fileList=[]},onUploadRemove:function(){this.toDefault(),console.log("onUploadRemove")},handleCheckChange:function(e,t,o){if(t){var a=[e.menuUuid];this.postForm.parentUuid=a[0],this.postForm.parentMenuName=e.title,this.$refs.tree.setCheckedKeys(a)}else this.postForm.parentUuid="",this.postForm.parentMenuName=""}}},g=b,y=(o("eac0"),o("2877")),x=Object(y["a"])(g,a,n,!1,null,null,null);t["default"]=x.exports},b804:function(e,t,o){"use strict";var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{style:{height:e.height+"px",zIndex:e.zIndex}},[o("div",{class:e.className,style:{top:e.isSticky?e.stickyTop+"px":"",zIndex:e.zIndex,position:e.position,width:e.width,height:e.height+"px"}},[e._t("default",[o("div",[e._v("sticky")])])],2)])},n=[],l=(o("c5f6"),{name:"Sticky",props:{stickyTop:{type:Number,default:0},zIndex:{type:Number,default:1},className:{type:String,default:""}},data:function(){return{active:!1,position:"",width:void 0,height:void 0,isSticky:!1}},mounted:function(){this.height=this.$el.getBoundingClientRect().height,window.addEventListener("scroll",this.handleScroll),window.addEventListener("resize",this.handleResize)},activated:function(){this.handleScroll()},destroyed:function(){window.removeEventListener("scroll",this.handleScroll),window.removeEventListener("resize",this.handleResize)},methods:{sticky:function(){this.active||(this.position="fixed",this.active=!0,this.width=this.width+"px",this.isSticky=!0)},handleReset:function(){this.active&&this.reset()},reset:function(){this.position="",this.width="auto",this.active=!1,this.isSticky=!1},handleScroll:function(){var e=this.$el.getBoundingClientRect().width;this.width=e||"auto";var t=this.$el.getBoundingClientRect().top;t<this.stickyTop?this.sticky():this.handleReset()},handleResize:function(){this.isSticky&&(this.width=this.$el.getBoundingClientRect().width+"px")}}}),i=l,r=o("2877"),s=Object(r["a"])(i,a,n,!1,null,null,null);t["a"]=s.exports},eac0:function(e,t,o){"use strict";var a=o("9493"),n=o.n(a);n.a},f3d1:function(e,t,o){"use strict";o.r(t);var a=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},n=[function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("aside",[e._v("\n  上传电子书分为两步：上传电子书和新增电子书。首先需要上传epub电子书文件，服务器会对epub文件进行解析，解析成功后会将电子书的各字段填入表单，之后我们只需要手动点击新增电子书即可完成电子书的保存。查看\n  "),o("a",{attrs:{href:"http://www.youbaobao.xyz/mpvue-docs/",target:"_blank"}},[e._v("\n    课程官网\n  ")]),e._v("\n  获取更多开发指引。\n")])}],l=o("2877"),i={},r=Object(l["a"])(i,a,n,!1,null,null,null);t["default"]=r.exports},fb1f:function(e,t,o){"use strict";var a=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"upload-container"},[o("el-upload",{staticClass:"image-upload",attrs:{action:e.action,headers:e.headers,multiple:!1,limit:1,"before-upload":e.beforeUpload,"on-success":e.onSuccess,"on-error":e.onError,"on-remove":e.onRemove,"file-list":e.fileList,"on-exceed":e.onExceed,disabled:e.disabled,drag:"","show-file-list":"",accept:"application/js+zip"}},[o("i",{staticClass:"el-icon-upload"}),e._v(" "),0==e.fileList.length?o("div",{staticClass:"el-upload__text"},[e._v("\n      请将电子书拖入或点击"),o("em",[e._v("上传")])]):o("div",{staticClass:"el-upload__text"},[e._v(" 图书已经上传")])])],1)},n=[],l=o("5f87"),i={name:"EbookUpload",props:{fileList:{type:Array,default:function(){return[]}},disabled:!1},data:function(){return{action:"".concat("","/book/upload")}},computed:{headers:function(){return{"X-Token":"".concat(Object(l["a"])())}}},methods:{beforeUpload:function(e){this.$emit("beforeUpload",e)},onSuccess:function(e,t){var o=e.code,a=e.msg,n=e.data;0===o?(this.$message({message:a,type:"success"}),this.$emit("onSuccess",n)):(this.$message({message:a&&"上传失败，原因：".concat(a)||"上传失败",type:"error"}),this.$emit("onError",t)),console.log(this.fileList)},onRemove:function(){this.$message({message:"电子书成功删除",type:"success"}),this.$emit("onRemove")},onError:function(e){console.log({err:e}),this.$emit("onError")},onExceed:function(){this.$message({message:"每次只能上传一本电子书",type:"waring"}),console.log("onExceed"),this.$emit("onExceed")}}},r=i,s=o("2877"),u=Object(s["a"])(r,a,n,!1,null,null,null);t["a"]=u.exports}}]);