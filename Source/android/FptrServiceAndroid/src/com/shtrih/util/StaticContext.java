package com.shtrih.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class StaticContext {

	public static void setContext(Context context) {
		SysUtils.setFilesPath(getFilesPath(context));
	}

	private static String getFilesPath(Context context)
	{
		File downloads = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);

		if (downloads != null) {

			if (downloads.exists())
				return downloads.getAbsolutePath() + File.separator;

			if (downloads.mkdirs())
				return downloads.getAbsolutePath() + File.separator;
		}

		return context.getFilesDir().getAbsolutePath() + File.separator;
	}
}
