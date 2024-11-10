package com.spring.config;

import java.lang.reflect.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;

/**
 * 系统启动后执行这里,运行浏览器
 */
@SpringBootConfiguration
public class AutoStartProjectInDefaultBrowser implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path}")
    private String path;

    /**
     springboot自带的监听任务,启动浏览器
     @param args
     @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            String url = "http://localhost:" + port + path;
            browse(url);
            //Runtime.getRuntime().exec("cmd /c start http://localhost:" + port + ""+path);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void browse(String url) {
        try {
            String osName = System.getProperty("os.name", "");
            if (osName.startsWith("Mac OS")) {
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL", String.class);
                openURL.invoke(null, url);
            } else if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                // Unix or Linux
                String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++) // 执行代码，在brower有值后跳出，
                // 这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0) browser = browsers[count];
                if (browser == null) throw new Exception("Could not find web browser"); else // 这个值在上面已经成功的得到了一个进程。
                Runtime.getRuntime().exec(new String[] { browser, url });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
