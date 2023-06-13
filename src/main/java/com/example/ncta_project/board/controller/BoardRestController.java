package com.example.ncta_project.board.controller;

import com.example.ncta_project.board.dto.InsertDTO;
import com.example.ncta_project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    //보류 ㅠ..
    @Value("${editor.img.save.url}")
    private String saveUrl;
    private final BoardService boardService;

//    @RequestMapping("/smarteditor")
//    public ModelAndView insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
//        ModelAndView mav = new ModelAndView("smarteditor/newPost");
//
//        return mav;
//    }
//
    @PostMapping("/ckeditor/saveBoard")
    public void saveBoard(Principal principal, @RequestBody InsertDTO insertDTO){
        boardService.insertBoard(principal.getName(), insertDTO);
    }

    @PostMapping("/smartEditor/multiImageUpload")
    public void smarteditorMultiImageUpload(HttpServletRequest request, HttpServletResponse response){
//        try {
//            //파일정보
//            String sFileInfo = "";
//            //파일명을 받는다 - 일반 원본파일명
//            String sFilename = request.getHeader("file-name");
//            //파일 확장자
//            String sFilenameExt = sFilename.substring(sFilename.lastIndexOf(".")+1);
//            //확장자를소문자로 변경
//            sFilenameExt = sFilenameExt.toLowerCase();
//
//            //이미지 검증 배열변수
//            String[] allowFileArr = {"jpg","png","bmp","gif"};
//
//            //확장자 체크
//            int nCnt = 0;
//            for(int i=0; i<allowFileArr.length; i++) {
//                if(sFilenameExt.equals(allowFileArr[i])){
//                    nCnt++;
//                }
//            }
//
//            //이미지가 아니라면
//            if(nCnt == 0) {
//                PrintWriter print = response.getWriter();
//                print.print("NOTALLOW_"+sFilename);
//                print.flush();
//                print.close();
//            } else {
//                String defalutPath = request.getSession().getServletContext().getRealPath("/");
//                //파일경로
////                String filePath = defalutPath+"img"+File.separator+"smarteditor"+File.separator;
//                String filePath = saveUrl;
//
//                File file = new File(filePath);
//                if(!file.exists()) {
//                    file.mkdirs();
//                }
//                String sRealFileNm = "";
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//                String today= formatter.format(new java.util.Date());
//                sRealFileNm = today+ UUID.randomUUID().toString() + sFilename.substring(sFilename.lastIndexOf("."));
//                String rlFileNm = filePath + sRealFileNm;
//
//                ///////////////// 서버에 파일쓰기 /////////////////
//                InputStream inputStream = request.getInputStream();
//                OutputStream outputStream=new FileOutputStream(rlFileNm);
//                int numRead;
//                byte bytes[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
//                while((numRead = inputStream.read(bytes,0,bytes.length)) != -1){
//                    outputStream.write(bytes,0,numRead);
//                }
//                if(inputStream != null) {
//                    inputStream.close();
//                }
//                outputStream.flush();
//                outputStream.close();
//                ///////////////// 이미지 /////////////////
//                // 정보 출력
//                sFileInfo += "&bNewLine=true";
//                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
//                sFileInfo += "&sFileName="+ sFilename;
//                sFileInfo += "&sFileURL="+"/img/smarteditor/"+sRealFileNm;
//                PrintWriter printWriter = response.getWriter();
//                printWriter.print(sFileInfo);
//                printWriter.flush();
//                printWriter.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            //파일정보
            String sFileInfo = "";
            //파일명을 받는다 - 일반 원본파일명
            String sFilename = request.getHeader("file-name");
            //파일 확장자
            String sFilenameExt = sFilename.substring(sFilename.lastIndexOf(".")+1);
            //확장자를소문자로 변경
            sFilenameExt = sFilenameExt.toLowerCase();

            //이미지 검증 배열변수
            String[] allowFileArr = {"jpg","png","bmp","gif"};

            //확장자 체크
            int nCnt = 0;
            for(int i=0; i<allowFileArr.length; i++) {
                if(sFilenameExt.equals(allowFileArr[i])){
                    nCnt++;
                }
            }

            //이미지가 아니라면
            if(nCnt == 0) {
                PrintWriter print = response.getWriter();
                print.print("NOTALLOW_"+sFilename);
                print.flush();
                print.close();
            } else {
                //디렉토리 설정 및 업로드

                String defalutPath = request.getServletContext().getRealPath("/");
                //파일경로
                String filePath = defalutPath+"img"+File.separator+"smarteditor"+File.separator;
                File file = new File(filePath);

                if(!file.exists()) {
                    file.mkdirs();
                }

                String sRealFileNm = "";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today= formatter.format(new java.util.Date());
                sRealFileNm = today+UUID.randomUUID().toString() + sFilename.substring(sFilename.lastIndexOf("."));
                String rlFileNm = filePath + sRealFileNm;

                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream inputStream = request.getInputStream();
                OutputStream outputStream=new FileOutputStream(rlFileNm);
                int numRead;
                byte bytes[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
                while((numRead = inputStream.read(bytes,0,bytes.length)) != -1){
                    outputStream.write(bytes,0,numRead);
                }
                if(inputStream != null) {
                    inputStream.close();
                }
                outputStream.flush();
                outputStream.close();

                ///////////////// 이미지 /////////////////
                // 정보 출력
                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName="+ sFilename;
                sFileInfo += "&sFileURL="+"/img/smarteditor/"+sRealFileNm;
                PrintWriter printWriter = response.getWriter();
                printWriter.print(sFileInfo);
                printWriter.flush();
                printWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/ckeditor/fileUpload")
    public void imageUpload(HttpServletRequest request,
                            HttpServletResponse response, MultipartHttpServletRequest multiFile
            , @RequestParam MultipartFile upload) throws Exception{
        // 랜덤 문자 생성
        UUID uid = UUID.randomUUID();

        OutputStream out = null;
        PrintWriter printWriter = null;

        //인코딩
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try{
            //파일 이름 가져오기
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();

            //이미지 경로 생성
            String path = saveUrl + "ckImage/";	// 이미지 경로 설정(폴더 자동 생성)
            String ckUploadPath = path + uid + "_" + fileName;
            File folder = new File(path);
            System.out.println("path:"+path);	// 이미지 저장경로 console에 확인
            //해당 디렉토리 확인
            if(!folder.exists()){
                try{
                    folder.mkdirs(); // 폴더 생성
                }catch(Exception e){
                    e.getStackTrace();
                }
            }

            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화

            String callback = request.getParameter("CKEditorFuncNum");
            printWriter = response.getWriter();
            String fileUrl = "/ckeditor/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // 작성화면

            // 업로드시 메시지 출력
            printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
            printWriter.flush();

        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(out != null) { out.close(); }
                if(printWriter != null) { printWriter.close(); }
            } catch(IOException e) { e.printStackTrace(); }
        }
        return;
    }

    @GetMapping(value="/ckeditor/ckImgSubmit")
    public void ckSubmit(@RequestParam(value="uid") String uid
            , @RequestParam(value="fileName") String fileName
            , HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //서버에 저장된 이미지 경로
        String path = saveUrl + "ckImage/";	// 저장된 이미지 경로
        System.out.println("path:"+path);
        String sDirPath = path + uid + "_" + fileName;

        File imgFile = new File(sDirPath);

        //사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
        if(imgFile.isFile()){
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;

            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;

            try{
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();

                while((readByte = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0, readByte);
                }

                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();

            }catch(IOException e){
                e.printStackTrace();
            }finally {
                outputStream.close();
                fileInputStream.close();
                out.close();
            }
        }
    }
}
