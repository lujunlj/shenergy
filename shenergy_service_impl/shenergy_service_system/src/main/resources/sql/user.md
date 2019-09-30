select
===
select * from sys_user where 1=1
@if(!isEmpty(age)){
and age = #age#
@}
@if(!isEmpty(name)){
and name = #name#
@}

selectByName
===
select * from sys_user where 1=1
and age = 13
@if(!isEmpty(name)){
and name = #name#
@}