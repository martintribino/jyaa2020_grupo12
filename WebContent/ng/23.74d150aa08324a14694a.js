(window.webpackJsonp=window.webpackJsonp||[]).push([[23],{D2Nj:function(t,a,i){"use strict";i.r(a),i.d(a,"ObraModule",(function(){return P}));var e=i("ofXK"),n=i("NFeN"),o=i("0IaG"),r=i("bTqV"),s=i("Xa2L"),c=i("Qu3c"),b=i("tyNb"),l=i("qR9t"),u=i("2Vo4"),d=i("hbUw"),h=i("nVpM"),g=i("fXoL"),m=i("lGQG"),f=i("dXND"),p=i("dNgK"),S=i("Wp6s"),v=i("f0Cb"),T=i("m1IW"),k=i("ytFt");function O(t,a){1&t&&g.Ob(0,"div")}function j(t,a){if(1&t&&(g.Tb(0,"div",4),g.Tb(1,"span"),g.zc(2),g.Sb(),g.Sb()),2&t){const t=a.$implicit;g.Bb(2),g.Cc("",t.nombre," ",t.apellido,"")}}function w(t,a){1&t&&g.Ob(0,"div")}function I(t,a){if(1&t){const t=g.Ub();g.Tb(0,"button",11),g.ac("click",(function(){return g.rc(t),g.ec(2).onAddPhoto()})),g.Tb(1,"mat-icon"),g.zc(2,"add_a_photo"),g.Sb(),g.Sb(),g.Tb(3,"button",12),g.ac("click",(function(){return g.rc(t),g.ec(2).onEdit()})),g.Tb(4,"mat-icon"),g.zc(5,"edit"),g.Sb(),g.Sb(),g.Tb(6,"button",13),g.ac("click",(function(){return g.rc(t),g.ec(2).onDelete()})),g.Tb(7,"mat-icon"),g.zc(8,"delete"),g.Sb(),g.Sb()}if(2&t){const t=g.ec(2);g.kc("disabled",t.loading),g.Bb(3),g.kc("disabled",t.loading),g.Bb(3),g.kc("disabled",t.loading)}}const q=function(){return["/obras/"]};function y(t,a){if(1&t){const t=g.Ub();g.Tb(0,"mat-card",3),g.Tb(1,"mat-card-header"),g.Tb(2,"mat-card-title"),g.zc(3),g.fc(4,"async"),g.Sb(),g.Sb(),g.Tb(5,"mat-card-content"),g.Tb(6,"div",4),g.Tb(7,"strong"),g.zc(8,"Descripci\xf3n"),g.Sb(),g.Tb(9,"span"),g.zc(10),g.fc(11,"async"),g.Sb(),g.Sb(),g.Ob(12,"mat-divider"),g.Tb(13,"div",4),g.Tb(14,"strong"),g.zc(15,"Duraci\xf3n"),g.Sb(),g.Tb(16,"span"),g.zc(17),g.fc(18,"async"),g.Sb(),g.Sb(),g.Ob(19,"mat-divider"),g.Tb(20,"div",4),g.Tb(21,"strong"),g.zc(22,"Artistas"),g.Sb(),g.Sb(),g.xc(23,j,3,2,"div",5),g.fc(24,"async"),g.Ob(25,"mat-divider"),g.Tb(26,"app-etiquetas-entidad",6),g.ac("agregar",(function(a){return g.rc(t),g.ec().agregarEtiqueta(a)}))("eliminar",(function(a){return g.rc(t),g.ec().eliminarEtiqueta(a)})),g.fc(27,"async"),g.Sb(),g.Ob(28,"app-carrusel-imagenes",7),g.fc(29,"async"),g.Sb(),g.Tb(30,"mat-card-actions"),g.Tb(31,"button",8),g.Tb(32,"mat-icon"),g.zc(33,"arrow_back_ios"),g.Sb(),g.Sb(),g.xc(34,w,1,0,"div",9),g.xc(35,I,9,3,"ng-template",null,10,g.yc),g.Sb(),g.Sb()}if(2&t){const t=g.oc(36),a=g.ec();var i,e,n,o;const c=null==(o=g.gc(24,16,a.obra))?null:o.artistas;var r;const b=null==(r=g.gc(27,18,a.obra))?null:r.etiquetas;var s;const l=null==(s=g.gc(29,20,a.obra))?null:s.fotos;g.Bb(3),g.Ac(null==(i=g.gc(4,10,a.obra))?null:i.nombre),g.Bb(7),g.Ac(null==(e=g.gc(11,12,a.obra))?null:e.descripcion),g.Bb(7),g.Ac(null==(n=g.gc(18,14,a.obra))?null:n.duracion),g.Bb(6),g.kc("ngForOf",c),g.Bb(3),g.kc("etiquetas",b)("loading",a.loading),g.Bb(2),g.kc("slides",l),g.Bb(3),g.kc("routerLink",g.lc(22,q)),g.Bb(3),g.kc("ngIf",a.isAdmin())("ngIfThen",t)}}function x(t,a){1&t&&g.Ob(0,"mat-spinner")}function z(t,a){1&t&&(g.Tb(0,"h5"),g.zc(1,"No se pudo cargar el obra."),g.Sb())}function B(t,a){if(1&t&&(g.xc(0,x,1,0,"mat-spinner",14),g.xc(1,z,2,0,"h5",14)),2&t){const t=g.ec();g.kc("ngIf",t.loading),g.Bb(1),g.kc("ngIf",!t.loading)}}const N=[{path:"",component:(()=>{class t{constructor(t,a,i,e,n,o){this.authService=t,this.obraServ=a,this.snackBar=i,this.dialog=e,this.router=n,this.route=o,this.obraSubject=new u.a(null),this.obra=this.obraSubject.asObservable(),this.loading=!1,this.id=null,this.route.params.subscribe(t=>{this.id=parseInt(t.id)})}ngOnInit(){this.loading=!0,this.obraServ.getObra(this.id).subscribe(t=>this.onSuccess(t),t=>this.onError(t),()=>this.loading=!1)}onSuccess(t){this.obraSubject.next(t),this.loading=!1}onError(t){this.obraSubject.next(null),this.loading=!1}onAddPhoto(){let t=this.obraSubject.value;null!=t&&this.dialog.open(h.a,{maxWidth:"550px",maxHeight:"100%",height:"auto",data:{action:l.a.crear,path:"obra",data:t}}).afterClosed().subscribe(t=>{this.ngOnInit()})}onEdit(){let t=this.obraSubject.value;null!=t&&this.dialog.open(d.a,{maxWidth:"550px",maxHeight:"100%",height:"auto",data:{action:l.a.editar,data:t}}).afterClosed().subscribe(t=>{let a=t;null!=a&&this.obraServ.actualizarObra(a).subscribe(()=>{this.mostrarMensaje("Se ha editado correctamente la obra "+a.nombre,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido actualizar la obra "+a.nombre,"error")})})}onDelete(){let t=this.obraSubject.value;null!=t&&(this.loading=!0,this.obraServ.eliminarObra(t).subscribe(()=>{this.mostrarMensaje("Se ha dado de baja correctamente la obra "+t.nombre,"success"),this.router.navigate(["/obras"])},()=>{this.mostrarMensaje("No se ha podido dar de baja la obra "+t.nombre,"error"),this.loading=!1},()=>{this.loading=!1}))}agregarEtiqueta(t){let a=this.obraSubject.value;if(null!=a){let i=[...a.etiquetas];a.etiquetas.push({id:null,nombre:t}),this.loading=!0,this.obraServ.actualizarObra(a).subscribe(()=>{this.mostrarMensaje("Se ha agregado la etiqueta "+t,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido agregar la etiqueta "+t,"error"),a.etiquetas=i,this.loading=!1},()=>{this.loading=!1})}}eliminarEtiqueta(t){let a=this.obraSubject.value;null!=a&&(a.etiquetas=a.etiquetas.filter(a=>a.id!=t.id),this.loading=!0,this.obraServ.actualizarObra(a).subscribe(()=>{this.mostrarMensaje("Se ha eliminado la etiqueta","success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido eliminar la etiqueta","error"),this.loading=!1},()=>{this.loading=!1}))}mostrarMensaje(t,a="",i=l.c,e="bottom"){this.snackBar.open(t,"",{duration:i,verticalPosition:e,panelClass:a})}isAdmin(){let t=this.authService.getUsuario();return null!=t&&t.rol==l.d.Administrador}}return t.\u0275fac=function(a){return new(a||t)(g.Nb(m.a),g.Nb(f.a),g.Nb(p.a),g.Nb(o.b),g.Nb(b.b),g.Nb(b.a))},t.\u0275cmp=g.Hb({type:t,selectors:[["app-obra"]],decls:6,vars:5,consts:[[4,"ngIf","ngIfThen","ngIfElse"],["ifBlock",""],["elseBlock",""],[1,"default-card"],[1,"card-row"],["class","card-row",4,"ngFor","ngForOf"],[3,"etiquetas","loading","agregar","eliminar"],[3,"slides"],["mat-icon-button","","matTooltip","Volver","matTooltipPosition","below","aria-label","Volver",1,"row-profile-button",3,"routerLink"],[4,"ngIf","ngIfThen"],["ifAdminBlock",""],["mat-icon-button","","matTooltip","Agregar Fotos","matTooltipPosition","below","aria-label","Agregar Fotos",1,"row-profile-button",3,"disabled","click"],["mat-icon-button","","matTooltip","Editar Obra","matTooltipPosition","below","aria-label","Editar Obra",1,"row-profile-button",3,"disabled","click"],["mat-icon-button","","matTooltip","Eliminar Obra","matTooltipPosition","below","aria-label","Eliminar Obra",1,"row-profile-button",3,"disabled","click"],[4,"ngIf"]],template:function(t,a){if(1&t&&(g.xc(0,O,1,0,"div",0),g.fc(1,"async"),g.xc(2,y,37,23,"ng-template",null,1,g.yc),g.xc(4,B,2,2,"ng-template",null,2,g.yc)),2&t){const t=g.oc(3),i=g.oc(5);g.kc("ngIf",null!=g.gc(1,3,a.obra))("ngIfThen",t)("ngIfElse",i)}},directives:[e.n,S.a,S.d,S.h,S.c,v.a,e.m,T.a,k.a,S.b,r.a,c.a,b.c,n.a,s.b],pipes:[e.b],styles:[".mat-progress-spinner[_ngcontent-%COMP%]{margin-top:2em}app-carrusel-imagenes[_ngcontent-%COMP%]{margin-top:10px}"]}),t})()}];let E=(()=>{class t{}return t.\u0275mod=g.Lb({type:t}),t.\u0275inj=g.Kb({factory:function(a){return new(a||t)},imports:[[b.f.forChild(N)],b.f]}),t})();var M=i("ugYk"),A=i("zOQo");let P=(()=>{class t{}return t.\u0275mod=g.Lb({type:t}),t.\u0275inj=g.Kb({factory:function(a){return new(a||t)},providers:[],imports:[[E,M.a,A.a,e.c,S.f,v.b,n.b,r.b,o.f,c.b,p.b,s.a]]}),t})()}}]);