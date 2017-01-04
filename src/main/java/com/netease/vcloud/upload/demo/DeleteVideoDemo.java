package com.netease.vcloud.upload.demo;

import java.io.IOException;

import com.netease.vcloud.VcloudException;
import com.netease.vcloud.client.VcloudClient;

public class DeleteVideoDemo {

	public static void main(String args[]) throws VcloudException, IOException {
		VcloudClient vcloudClient = new VcloudClient();
		int vid = 62230;
		int style = 1;
		String str;
		str = vcloudClient.deleteVideo(vid, style);
		System.out.println(str);
	}
}
