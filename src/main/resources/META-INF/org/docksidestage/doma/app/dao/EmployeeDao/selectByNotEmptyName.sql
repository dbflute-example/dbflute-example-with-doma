select /*%expand*/* from employee where /*%if @isNotEmpty(name) */ name = /* name */'hoge' /*%end*/