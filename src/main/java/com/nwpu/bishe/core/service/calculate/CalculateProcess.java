package com.nwpu.bishe.core.service.calculate;

import java.io.IOException;

/**
 * Created by chunk on 2017/10/23.
 */
public class CalculateProcess  implements Runnable{

    private String cmd ;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void run() {

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            int i = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
