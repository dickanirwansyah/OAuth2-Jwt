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

```
$ curl clientGojekApp:mysecret@localhost:8080/oauth/token -d grant_type=password -d username=dickanirwansyah@gmail.com -d password=rootroot
```
<br/>
# Mendapatkan Token di Auth Server

```

{
"access_token":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTgwNzY0NjcsInVzZXJfbmFtZSI6ImRpY2thbmlyd2Fuc3lhaEBnbWFpbC 5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTUFETUlOIl0sImp0aSI6IjVjZDYwZDdjLTNkODktNGVhYi1iMTQ2LWNmYmI2N2EyNTlmZiIsImNsaWVudF9pZCI6ImNsaWVudEdvamVrQXBwIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.2LKPT5LYZWQCl6AEgJ_e9a62TX4VxlLqtExgm-ka3dSOpnR9N9DP3zhT--qmLfiU2yA6SMS5zfly-rShRHhgzapoBJ_PnBprZVdJTEGD7WZCEywBfqtVgBoolBNLCeY8AMMtg8azoYrzCL08uQ-2oIbbLG4YK79aWO8atIMYKoskuJbJ8oq9IWmVqtCqOVB8bFhl2yMG1RzUqc_7UfWrVb6IV5SFXkhH2-Gwr27EYnI5Z2qhaZ_sr-8mI8dIWelAt0Yw2340ybOwHKgcU7PXVoc9zMpmw9NbOCkPStYxHUnz92eT3Lhq29y8fMmospEMQJ28HEKEB1sOyU8tlhznww",
"token_type":"bearer",
"refresh_token":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJkaWNrYW5pcndhbnN5YWhAZ21haWwuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6IjVjZDYwZDdjLTNkODktNGVhYi1iMTQ2LWNmYmI2N2EyNTlmZiIsImV4cCI6MTUxODA3NjQ2NywiYXV0aG9yaXRpZXMiOlsiUk9MRV9TWVNURU1BRE1JTiJdLCJqdGkiOiI2Mzc5YWU1NC04ZGU4LTQyODMtYmUzZS01OGM5YTEzYWZkNTMiLCJjbGllbnRfaWQiOiJjbGllbnRHb2pla0FwcCJ9.yAtx3AtWUN4U0w4sQgVnkW72laRE8nTMTlLrDEZXQJBGEktxcrR2fIrYr3J2AsuSsnsvIpge289cpztR7SbtC9J-haQLuEi6xhqqRmlbnIVeH3CabTQfRN6-jZrlU1RHH3yUyOB1W6Tfhi8lHxpjAP-gqNgRVa6Up9T8Jd8NwowB477mD-nqDhaAVbbe1fkGL3lXbwET6MOXQatwGA818dgGgMDgZNHx40OYfyZTB6aSaUBtJ6jQxqm-UiSJehWvp0FQ9mh5hK-h6p9dsF326VhRJ8NqfYOpdvlDmsceWUmmw-sR5Op67cuxcjPBrhcY9IoINfW12dS9m0kw0urTJA",
"expires_in":19999,
"scope":"read write",
"jti":"5cd60d7c-3d89-4eab-b146-cfbb67a259ff"
}
```
<br/>
# Access Token ke Resource Server

```

$ curl http://localhost:8081/api/resource/sys -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTgwNzY0NjcsInVzZXJfbmFtZSI6ImRpY2thbmlyd2Fuc3lhaEBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTUFETUlOIl0sImp0aSI6IjVjZDYwZDdjLTNkODktNGVhYi1iMTQ2LWNmYmI2N2EyNTlmZiIsImNsaWVudF9pZCI6ImNsaWVudEdvamVrQXBwIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.2LKPT5LYZWQCl6AEgJ_e9a62TX4VxlLqtExgm-ka3dSOpnR9N9DP3zhT--qmLfiU2yA6SMS5zfly-rShRHhgzapoBJ_PnBprZVdJTEGD7WZCEywBfqtVgBoolBNLCeY8AMMtg8azoYrzCL08uQ-2oIbbLG4YK79aWO8atIMYKoskuJbJ8oq9IWmVqtCqOVB8bFhl2yMG1RzUqc_7UfWrVb6IV5SFXkhH2-Gwr27EYnI5Z2qhaZ_sr-8mI8dIWelAt0Yw2340ybOwHKgcU7PXVoc9zMpmw9NbOCkPStYxHUnz92eT3Lhq29y8fMmospEMQJ28HEKEB1sOyU8tlhznww"
```
