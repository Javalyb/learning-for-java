package priv.lyb;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: Apollo
 * @Description:
 * @Date: 11:09 2021/05/05
 */
public class OptimizePdf {
    /**
     * 打包压缩下载pdf文件
     * @param session HttpSession
     * @param response HttpServletResponse
     * @param filePathId filePath序列ID
     * @throws IOException IO异常
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/downLoadZipFile")
    public void downLoadZipFile(HttpSession session, HttpServletResponse response, int filePathId) throws IOException {
        try {
            //pdf压缩并下载
            //Itext2PDFUtil.pdfToZip(response,zipName, fileDe,pdfName+".zip");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
    }

    public static void main(String[] args) throws Exception {
        Itext2PDFUtil.pdfToZip(null,"//Users//liuyingbo//Downloads//1Z45F12A0303136935M.zip", "//Users//liuyingbo//Downloads//1Z45F12A0303136935M.pdf","pdfName"+".zip");
    }
}
