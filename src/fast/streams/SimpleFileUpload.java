package fast.streams;

import fast.Parameters;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import spark.Request;
import spark.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * User: k33g_org
 * Date: 5/4/13
 * Time: 12:52 PM
 */

public class SimpleFileUpload {

    private HashMap<String,String> filesList = new HashMap<>();

    public HashMap<String, String> filesList() {
        return filesList;
    }

    public SimpleFileUpload doPost(Request request, Response response, String where) {

        try {
            doPost(request.raw(), response.raw(), where);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response, String where)
            throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    if (!item.isFormField()) {

                        String fileName = item.getName();

                        String root = (new File(Parameters.publicDir)).getAbsolutePath();
                        File path = new File(root + "/"+ where);
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        String uid = UUID.randomUUID().toString();
                        File uploadedFile = new File(path + "/" + uid+"_"+ fileName);
                        //System.out.println(uploadedFile.getAbsolutePath());

                        filesList.put(uid,fileName);

                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}