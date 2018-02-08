<h3>Spring Boot OAuth2 & JWT</h3>
<hr/>
Aplikasi terdiri dari : 
<ul>
<li>1. Aplikasi OAuth2-Authorization Server</li>
<li>2. Aplikasi OAuth2-Resource Server</li>
</ul>
<br/>
# OAuth2 Authorization Server - Dependencies Gradle
<ul>
<li>1. MySQL</li>
<li>2. Spring Security</li>
<li>3. Spring Security OAuth2</li>
<li>4. Spring Security Jwt</li>
</ul>
# Jalankan Aplikasi OAuth2 Authorization Server
ketik <b><i>java-jar build/libs/OAuth2-AuthServer-0.0.1-SNAPSHOT.jar</i></b>  di command line 
<br/>
<br/>
# Jalankan Aplikasi OAuth2 Resource Server 
ketik <b><i>mvn clean spring-boot:run</i></b>
<br/>
<br/>
# Mendapatkan Token
<br/>

`
$ curl clientGojekApp:mysecret@localhost:8080/oauth/token -d grant_type=password -d username=dickanirwansyah@gmail.com -d password=rootroot

