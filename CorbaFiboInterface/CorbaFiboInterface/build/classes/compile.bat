:: Directorio de java SDK
SET JAVA_HOME="C:\Program Files\Android\jdk\microsoft_dist_openjdk_1.8.0.25"

:: direccion de las fuentes SRC de proyecto
SET PATH_IDL="C:\RepositoriosComputoDistribuido\CORBA\CorbaFiboInterface\CorbaFiboInterface\src"


:: nombre del archivo IDL
SET IDL_NAME=fibonacci.idl

:: comando para compilar
%JAVA_HOME%\bin\idlj -fall -td %PATH_IDL% %PATH_IDL%\%IDL_NAME%


