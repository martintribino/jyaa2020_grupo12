(window.webpackJsonp=window.webpackJsonp||[]).push([[16],{ITA0:function(t,a,i){"use strict";i.r(a),i.d(a,"EspacioModule",(function(){return O}));var e=i("tyNb"),n=i("2Vo4"),c=i("qR9t"),r=i("YsU4"),o=i("fXoL"),s=i("lGQG"),d=i("7B7A"),l=i("dNgK"),m=i("0IaG"),b=i("ofXK"),u=i("Wp6s"),p=i("f0Cb"),g=i("bTqV"),h=i("Qu3c"),f=i("NFeN"),x=i("m1IW"),S=i("Xa2L");function v(t,a){1&t&&o.Ob(0,"div")}function T(t,a){1&t&&o.Ob(0,"div")}function y(t,a){if(1&t){const t=o.Ub();o.Tb(0,"div",4),o.Tb(1,"strong"),o.zc(2,"Ubicaci\xf3n"),o.Sb(),o.Sb(),o.Tb(3,"div",4),o.Tb(4,"strong"),o.zc(5,"Calle"),o.Sb(),o.Tb(6,"span"),o.zc(7),o.fc(8,"async"),o.Sb(),o.Sb(),o.Ob(9,"mat-divider"),o.Tb(10,"div",4),o.Tb(11,"strong"),o.zc(12,"Ciudad"),o.Sb(),o.Tb(13,"span"),o.zc(14),o.fc(15,"async"),o.Sb(),o.Sb(),o.Ob(16,"mat-divider"),o.Tb(17,"div",4),o.Tb(18,"strong"),o.zc(19,"Estado"),o.Sb(),o.Tb(20,"span"),o.zc(21),o.fc(22,"async"),o.Sb(),o.Sb(),o.Ob(23,"mat-divider"),o.Tb(24,"div",4),o.Tb(25,"strong"),o.zc(26,"C\xf3digo Postal"),o.Sb(),o.Tb(27,"span"),o.zc(28),o.fc(29,"async"),o.Sb(),o.Sb(),o.Ob(30,"mat-divider"),o.Tb(31,"app-etiquetas-entidad",9),o.ac("agregar",(function(a){return o.rc(t),o.ec(2).agregarEtiqueta(a)}))("eliminar",(function(a){return o.rc(t),o.ec(2).eliminarEtiqueta(a)})),o.fc(32,"async"),o.Sb()}if(2&t){const t=o.ec(2);var i,e,n,c,r;const a=null==(r=o.gc(32,14,t.espacio))?null:r.etiquetas;o.Bb(7),o.Ac(null==(i=o.gc(8,6,t.espacio))||null==i.direccion?null:i.direccion.calle),o.Bb(7),o.Ac(null==(e=o.gc(15,8,t.espacio))||null==e.direccion?null:e.direccion.ciudad),o.Bb(7),o.Ac(null==(n=o.gc(22,10,t.espacio))||null==n.direccion?null:n.direccion.estado),o.Bb(7),o.Ac(null==(c=o.gc(29,12,t.espacio))||null==c.direccion?null:c.direccion.codigoPostal),o.Bb(3),o.kc("etiquetas",a)("loading",t.loading)}}function w(t,a){1&t&&o.Ob(0,"div")}function k(t,a){if(1&t){const t=o.Ub();o.Tb(0,"button",10),o.ac("click",(function(){return o.rc(t),o.ec(2).onEdit()})),o.Tb(1,"mat-icon"),o.zc(2,"edit"),o.Sb(),o.Sb(),o.Tb(3,"button",11),o.ac("click",(function(){return o.rc(t),o.ec(2).onDelete()})),o.Tb(4,"mat-icon"),o.zc(5,"delete"),o.Sb(),o.Sb()}if(2&t){const t=o.ec(2);o.kc("disabled",t.loading),o.Bb(3),o.kc("disabled",t.loading)}}const z=function(){return["/espacios/"]};function I(t,a){if(1&t&&(o.Tb(0,"mat-card",3),o.Tb(1,"mat-card-header"),o.Tb(2,"mat-card-title"),o.zc(3),o.fc(4,"async"),o.Sb(),o.Sb(),o.Tb(5,"mat-card-content"),o.Tb(6,"div",4),o.Tb(7,"strong"),o.zc(8,"Descripci\xf3n"),o.Sb(),o.Tb(9,"span"),o.zc(10),o.fc(11,"async"),o.Sb(),o.Sb(),o.Ob(12,"mat-divider"),o.Tb(13,"div",4),o.Tb(14,"strong"),o.zc(15,"Capacidad"),o.Sb(),o.Tb(16,"span"),o.zc(17),o.fc(18,"async"),o.Sb(),o.Sb(),o.Ob(19,"mat-divider"),o.Tb(20,"div",4),o.Tb(21,"strong"),o.zc(22,"Condici\xf3n"),o.Sb(),o.Tb(23,"span"),o.zc(24),o.fc(25,"async"),o.Sb(),o.Sb(),o.Ob(26,"mat-divider"),o.xc(27,T,1,0,"div",5),o.fc(28,"async"),o.xc(29,y,33,16,"ng-template",null,6,o.yc),o.Sb(),o.Tb(31,"mat-card-actions"),o.Tb(32,"button",7),o.Tb(33,"mat-icon"),o.zc(34,"arrow_back_ios"),o.Sb(),o.Sb(),o.xc(35,w,1,0,"div",5),o.xc(36,k,6,2,"ng-template",null,8,o.yc),o.Sb(),o.Sb()),2&t){const t=o.oc(30),a=o.oc(37),s=o.ec();var i,e,n,c,r;const d=null!=(null==(r=o.gc(28,17,s.espacio))?null:r.direccion);o.Bb(3),o.Ac(null==(i=o.gc(4,9,s.espacio))?null:i.nombre),o.Bb(7),o.Ac(null==(e=o.gc(11,11,s.espacio))?null:e.descripcion),o.Bb(7),o.Ac(null==(n=o.gc(18,13,s.espacio))?null:n.capacidad),o.Bb(7),o.Ac(null==(c=o.gc(25,15,s.espacio))?null:c.condicion),o.Bb(3),o.kc("ngIf",d)("ngIfThen",t),o.Bb(5),o.kc("routerLink",o.lc(19,z)),o.Bb(3),o.kc("ngIf",s.isAdmin())("ngIfThen",a)}}function j(t,a){1&t&&o.Ob(0,"mat-spinner")}function A(t,a){1&t&&(o.Tb(0,"h5"),o.zc(1,"No se pudo cargar el espacio."),o.Sb())}function E(t,a){if(1&t&&(o.xc(0,j,1,0,"mat-spinner",12),o.xc(1,A,2,0,"h5",12)),2&t){const t=o.ec();o.kc("ngIf",t.loading),o.Bb(1),o.kc("ngIf",!t.loading)}}const C=[{path:"",component:(()=>{class t{constructor(t,a,i,e,c,r){this.authService=t,this.espacioServ=a,this.snackBar=i,this.dialog=e,this.router=c,this.route=r,this.espacioSubject=new n.a(null),this.espacio=this.espacioSubject.asObservable(),this.loading=!1,this.id=null,this.route.params.subscribe(t=>{this.id=parseInt(t.id)})}ngOnInit(){this.loading=!0,this.espacioServ.getEspacio(this.id).subscribe(t=>this.onSuccess(t),t=>this.onError(t),()=>this.loading=!1)}onSuccess(t){this.espacioSubject.next(t),this.loading=!1}onError(t){this.espacioSubject.next(null),this.loading=!1}onEdit(){let t=this.espacioSubject.value;null!=t&&this.dialog.open(r.a,{maxWidth:"550px",maxHeight:"100%",height:"auto",data:{action:c.a.editar,data:t}}).afterClosed().subscribe(t=>{let a=t;null!=a&&this.espacioServ.actualizarEspacio(a).subscribe(()=>{this.mostrarMensaje("Se ha editado correctamente el espacio "+a.nombre,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido actualizar el espacio "+a.nombre,"error")})})}onDelete(){let t=this.espacioSubject.value;null!=t&&(this.loading=!0,this.espacioServ.eliminarEspacio(t).subscribe(()=>{this.mostrarMensaje("Se ha dado de baja correctamente al espacio "+t.nombre,"success"),this.router.navigate(["/espacios"])},()=>{this.mostrarMensaje("No se ha podido dar de baja el espacio "+t.nombre,"error"),this.loading=!1},()=>{this.loading=!1}))}agregarEtiqueta(t){let a=this.espacioSubject.value;if(null!=a){let i=[...a.etiquetas];a.etiquetas.push({id:null,nombre:t}),this.loading=!0,this.espacioServ.actualizarEspacio(a).subscribe(()=>{this.mostrarMensaje("Se ha agregado la etiqueta "+t,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido agregar la etiqueta "+t,"error"),a.etiquetas=i,this.loading=!1},()=>{this.loading=!1})}}eliminarEtiqueta(t){let a=this.espacioSubject.value;null!=a&&(a.etiquetas=a.etiquetas.filter(a=>a.id!=t.id),this.loading=!0,this.espacioServ.actualizarEspacio(a).subscribe(()=>{this.mostrarMensaje("Se ha eliminado la etiqueta","success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido eliminar la etiqueta","error"),this.loading=!1},()=>{this.loading=!1}))}mostrarMensaje(t,a="",i=c.c,e="bottom"){this.snackBar.open(t,"",{duration:i,verticalPosition:e,panelClass:a})}isAdmin(){let t=this.authService.getUsuario();return null!=t&&t.rol==c.d.Administrador}}return t.\u0275fac=function(a){return new(a||t)(o.Nb(s.a),o.Nb(d.a),o.Nb(l.a),o.Nb(m.b),o.Nb(e.b),o.Nb(e.a))},t.\u0275cmp=o.Hb({type:t,selectors:[["app-espacio"]],decls:6,vars:5,consts:[[4,"ngIf","ngIfThen","ngIfElse"],["ifBlock",""],["elseBlock",""],[1,"default-card"],[1,"card-row"],[4,"ngIf","ngIfThen"],["ifDireccionBlock",""],["mat-icon-button","","matTooltip","Volver","matTooltipPosition","below","aria-label","Volver",1,"row-profile-button",3,"routerLink"],["ifAdminBlock",""],[3,"etiquetas","loading","agregar","eliminar"],["mat-icon-button","","matTooltip","Editar Espacio","matTooltipPosition","below","aria-label","Editar Espacio",1,"row-profile-button",3,"disabled","click"],["mat-icon-button","","matTooltip","Eliminar Espacio","matTooltipPosition","below","aria-label","Eliminar Espacio",1,"row-profile-button",3,"disabled","click"],[4,"ngIf"]],template:function(t,a){if(1&t&&(o.xc(0,v,1,0,"div",0),o.fc(1,"async"),o.xc(2,I,38,20,"ng-template",null,1,o.yc),o.xc(4,E,2,2,"ng-template",null,2,o.yc)),2&t){const t=o.oc(3),i=o.oc(5);o.kc("ngIf",null!=o.gc(1,3,a.espacio))("ngIfThen",t)("ngIfElse",i)}},directives:[b.n,u.a,u.d,u.h,u.c,p.a,u.b,g.a,h.a,e.c,f.a,x.a,S.b],pipes:[b.b],styles:[""]}),t})()}];let B=(()=>{class t{}return t.\u0275mod=o.Lb({type:t}),t.\u0275inj=o.Kb({factory:function(a){return new(a||t)},imports:[[e.f.forChild(C)],e.f]}),t})();var q=i("ugYk"),N=i("zOQo");let O=(()=>{class t{}return t.\u0275mod=o.Lb({type:t}),t.\u0275inj=o.Kb({factory:function(a){return new(a||t)},providers:[],imports:[[B,q.a,N.a,b.c,u.f,p.b,f.b,g.b,m.f,h.b,l.b,S.a]]}),t})()},Wp6s:function(t,a,i){"use strict";i.d(a,"a",(function(){return g})),i.d(a,"b",(function(){return u})),i.d(a,"c",(function(){return l})),i.d(a,"d",(function(){return h})),i.d(a,"e",(function(){return p})),i.d(a,"f",(function(){return f})),i.d(a,"g",(function(){return b})),i.d(a,"h",(function(){return m}));var e=i("R1ws"),n=i("FKr1"),c=i("fXoL");const r=["*",[["mat-card-footer"]]],o=["*","mat-card-footer"],s=[[["","mat-card-avatar",""],["","matCardAvatar",""]],[["mat-card-title"],["mat-card-subtitle"],["","mat-card-title",""],["","mat-card-subtitle",""],["","matCardTitle",""],["","matCardSubtitle",""]],"*"],d=["[mat-card-avatar], [matCardAvatar]","mat-card-title, mat-card-subtitle,\n      [mat-card-title], [mat-card-subtitle],\n      [matCardTitle], [matCardSubtitle]","*"];let l=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275dir=c.Ib({type:t,selectors:[["mat-card-content"],["","mat-card-content",""],["","matCardContent",""]],hostAttrs:[1,"mat-card-content"]}),t})(),m=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275dir=c.Ib({type:t,selectors:[["mat-card-title"],["","mat-card-title",""],["","matCardTitle",""]],hostAttrs:[1,"mat-card-title"]}),t})(),b=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275dir=c.Ib({type:t,selectors:[["mat-card-subtitle"],["","mat-card-subtitle",""],["","matCardSubtitle",""]],hostAttrs:[1,"mat-card-subtitle"]}),t})(),u=(()=>{class t{constructor(){this.align="start"}}return t.\u0275fac=function(a){return new(a||t)},t.\u0275dir=c.Ib({type:t,selectors:[["mat-card-actions"]],hostAttrs:[1,"mat-card-actions"],hostVars:2,hostBindings:function(t,a){2&t&&c.Eb("mat-card-actions-align-end","end"===a.align)},inputs:{align:"align"},exportAs:["matCardActions"]}),t})(),p=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275dir=c.Ib({type:t,selectors:[["","mat-card-image",""],["","matCardImage",""]],hostAttrs:[1,"mat-card-image"]}),t})(),g=(()=>{class t{constructor(t){this._animationMode=t}}return t.\u0275fac=function(a){return new(a||t)(c.Nb(e.a,8))},t.\u0275cmp=c.Hb({type:t,selectors:[["mat-card"]],hostAttrs:[1,"mat-card","mat-focus-indicator"],hostVars:2,hostBindings:function(t,a){2&t&&c.Eb("_mat-animation-noopable","NoopAnimations"===a._animationMode)},exportAs:["matCard"],ngContentSelectors:o,decls:2,vars:0,template:function(t,a){1&t&&(c.jc(r),c.ic(0),c.ic(1,1))},styles:[".mat-card{transition:box-shadow 280ms cubic-bezier(0.4, 0, 0.2, 1);display:block;position:relative;padding:16px;border-radius:4px}._mat-animation-noopable.mat-card{transition:none;animation:none}.mat-card .mat-divider-horizontal{position:absolute;left:0;width:100%}[dir=rtl] .mat-card .mat-divider-horizontal{left:auto;right:0}.mat-card .mat-divider-horizontal.mat-divider-inset{position:static;margin:0}[dir=rtl] .mat-card .mat-divider-horizontal.mat-divider-inset{margin-right:0}.cdk-high-contrast-active .mat-card{outline:solid 1px}.mat-card-actions,.mat-card-subtitle,.mat-card-content{display:block;margin-bottom:16px}.mat-card-title{display:block;margin-bottom:8px}.mat-card-actions{margin-left:-8px;margin-right:-8px;padding:8px 0}.mat-card-actions-align-end{display:flex;justify-content:flex-end}.mat-card-image{width:calc(100% + 32px);margin:0 -16px 16px -16px}.mat-card-footer{display:block;margin:0 -16px -16px -16px}.mat-card-actions .mat-button,.mat-card-actions .mat-raised-button,.mat-card-actions .mat-stroked-button{margin:0 8px}.mat-card-header{display:flex;flex-direction:row}.mat-card-header .mat-card-title{margin-bottom:12px}.mat-card-header-text{margin:0 16px}.mat-card-avatar{height:40px;width:40px;border-radius:50%;flex-shrink:0;object-fit:cover}.mat-card-title-group{display:flex;justify-content:space-between}.mat-card-sm-image{width:80px;height:80px}.mat-card-md-image{width:112px;height:112px}.mat-card-lg-image{width:152px;height:152px}.mat-card-xl-image{width:240px;height:240px;margin:-8px}.mat-card-title-group>.mat-card-xl-image{margin:-8px 0 8px}@media(max-width: 599px){.mat-card-title-group{margin:0}.mat-card-xl-image{margin-left:0;margin-right:0}}.mat-card>:first-child,.mat-card-content>:first-child{margin-top:0}.mat-card>:last-child:not(.mat-card-footer),.mat-card-content>:last-child:not(.mat-card-footer){margin-bottom:0}.mat-card-image:first-child{margin-top:-16px;border-top-left-radius:inherit;border-top-right-radius:inherit}.mat-card>.mat-card-actions:last-child{margin-bottom:-8px;padding-bottom:0}.mat-card-actions .mat-button:first-child,.mat-card-actions .mat-raised-button:first-child,.mat-card-actions .mat-stroked-button:first-child{margin-left:0;margin-right:0}.mat-card-title:not(:first-child),.mat-card-subtitle:not(:first-child){margin-top:-4px}.mat-card-header .mat-card-subtitle:not(:first-child){margin-top:-8px}.mat-card>.mat-card-xl-image:first-child{margin-top:-8px}.mat-card>.mat-card-xl-image:last-child{margin-bottom:-8px}\n"],encapsulation:2,changeDetection:0}),t})(),h=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275cmp=c.Hb({type:t,selectors:[["mat-card-header"]],hostAttrs:[1,"mat-card-header"],ngContentSelectors:d,decls:4,vars:0,consts:[[1,"mat-card-header-text"]],template:function(t,a){1&t&&(c.jc(s),c.ic(0),c.Tb(1,"div",0),c.ic(2,1),c.Sb(),c.ic(3,2))},encapsulation:2,changeDetection:0}),t})(),f=(()=>{class t{}return t.\u0275mod=c.Lb({type:t}),t.\u0275inj=c.Kb({factory:function(a){return new(a||t)},imports:[[n.i],n.i]}),t})()}}]);