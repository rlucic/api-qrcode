# api-qrcode
generates QR codes

### Model/body for calling the POST methods: 
     {
      "text": "Some sample text",
      "format": "B64"
     }

### Headers for content negotiation
`- Accept : text/plain , for a Base64 encoded QRCode image`

`- Accept : image/png , for a streamed QRCode image`


### Version V1 of the API 
Is using the QR Code library: com.github.kenglxn
sample test calls (no Accept header needed):
- GET: http://localhost:8080/api-qrcode/image/getpng/{image-name-no-extension}
- GET: http://localhost:8080/api-qrcode/image/getb64/{image-name-no-extension}

sample calls: 
- GET: http://localhost:8080/api-qrcode/image/v1/test1 (only test1.png exists)

Accept : text/plain , for a Base64 encoded QRCode image from hardcoded text

Accept : image/png , for a streamed QRCode image from hardcoded text

- POST: http://localhost:8080/api-qrcode/image/v1/generate

Accept : text/plain , for a Base64 encoded QRCode image from the model text field

Accept : image/png , for a streamed QRCode image from the model text field


