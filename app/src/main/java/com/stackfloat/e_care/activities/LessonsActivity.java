package com.stackfloat.e_care.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;
import androidx.core.text.TextUtilsCompat;

import com.stackfloat.e_care.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LessonsActivity extends AppCompatActivity {

    public static final String LESSON_POSITION = "com.stackfloat.e_care.activities.LessonsActivity.LESSON_POSITION";
    public static final int INVALID_LESSON = -1;
    private int mLessonPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        Intent intent = getIntent();
        mLessonPosition = intent.getIntExtra(LESSON_POSITION, INVALID_LESSON);
        String[] lessonNames =getResources().getStringArray(R.array.lesson_names);
        String[] lessonContents =getResources().getStringArray(R.array.lesson_contents);
        Toolbar toolbar = findViewById(R.id.lessonsToolbar);
        toolbar.setTitle(lessonNames[mLessonPosition]);
        setSupportActionBar(toolbar);
        TextView txtContent= findViewById(R.id.tv_lesson_content);
        txtContent.setText(getLessonContent(lessonContents));
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Spanned getLessonContent(String[] lessonContents) {
        String lessonContent =(lessonContents[mLessonPosition]);
        return HtmlCompat.fromHtml(lessonContent, HtmlCompat.FROM_HTML_MODE_LEGACY);
    }

    private void init() throws IOException {
//        final ContentLessonsBinding  binding= ContentLessonsBinding.inflate(getLayoutInflater());

        // WebView alcPage=findViewById(R.id.wv_lesson);


//        PDFView pdfView = findViewById(R.id.pdf_viewer);
//        pdfView.fromAsset("tetpdf.pdf")
//                .password(null)
//                .defaultPage(0)
//                .enableDoubletap(true)
//                .onPageError(new OnPageErrorListener() {
//                    @Override
//                    public void onPageError(int page, Throwable t) {
//                        Toast.makeText(LessonsActivity.this,
//                                "error page ", Toast.LENGTH_LONG).show();
//                    }
//                }).load();

       // alcPage.getSettings().setBlockNetworkLoads(false);
//        enable javascript
        //alcPage.getSettings().setJavaScriptEnabled(true);
//        enable cache
       // alcPage.getSettings().setAppCacheEnabled(true);

//        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        //alcPage.loadUrl("https://onedrive.live.com/view.aspx?resid=2D59571A76FFB58C!1930&ithint=file%2cdocx&authkey=!AtEyrXRs2HuOvKs");
//
        //disable network load error

//        //load the about ALC page URL
//        alcPage.loadUrl("https:/andela.com/alc/");
        //Handles the andela https sslError that prevents the url from loading
//        alcPage.loadUrl(readAssetAndMakeCopy(getAssets()));
//        alcPage.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();
//            }
//        });
//        alcPage.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                if (progress < 100) {
////                    progressDialog.show();
//                }
//                if (progress == 100) {
////                    progressDialog.dismiss();
//                }
//            }
//        });
    }

    private String readAssetAndMakeCopy(AssetManager assetManager) {

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "tetpdf.pdf");
        try {
            in = assetManager.open("tetpdf.pdf");
            out = openFileOutput(file.getName(), MODE_APPEND);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
            e.printStackTrace();
        }

//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.parse(
        String s = "file://" + getFilesDir() + "/tetpdf.pdf";
        return s;
//                ), "application/pdf");
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[450024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(LessonsActivity.this, QuestionsActivity.class);
        intent.putExtra(QuestionsActivity.QUESTIONS_INDEX, mLessonPosition);
        startActivity(intent);
    }
}