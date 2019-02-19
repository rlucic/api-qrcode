# api-qrcode
generates QR codes

##Sample calls


##Version V1 of the API 
Is using the QR Code library: com.github.kenglxn
sample calls: 
- http://localhost:8080/api-qrcode/image/v1/test/png
- http://localhost:8080/api-qrcode/image/v1/test/b64
- http://localhost:8080/api-qrcode/image/v1/generate/png

##Model: 
{
 text: "Some sample text",
 format: "B64"
}