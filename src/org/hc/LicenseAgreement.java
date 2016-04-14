package org.hc;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;

public class LicenseAgreement {
	public static final String PREFERENCE_EULA_ACCEPTED = "eula.accepted";
	public static final String PREFERENCES_EULA = "eula";

	static void showLicenseAgreement(final Activity activity) {
		final SharedPreferences preferences = activity.getSharedPreferences(
				PREFERENCES_EULA, Activity.MODE_PRIVATE);
		if (!preferences.getBoolean(PREFERENCE_EULA_ACCEPTED, false)) {
			final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setTitle("License");
			builder.setCancelable(false);
			builder.setPositiveButton("Accept",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							preferences.edit().putBoolean(PREFERENCE_EULA_ACCEPTED,
									true).commit();
						}
					});
	        builder.setNegativeButton("Refuse", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	activity.finish();
	            }
	        });
			builder.setMessage("END-USER LICENSE AGREEMENT FOR HALALCHECKER IMPORTANT PLEASE READ THE TERMS AND CONDITIONS OF THIS LICENSE AGREEMENT CAREFULLY BEFORE CONTINUING WITH THIS PROGRAM INSTALL: Active Apps's End-User License Agreement (EULA) is a legal agreement between you (either an individual or a single entity) and Active Apps. for the Active Apps software product(s) identified above which may include associated software components, media, printed materials, and online or electronic documentation (SOFTWARE PRODUCT). By installing, copying, or otherwise using the SOFTWARE PRODUCT, you agree to be bound by the terms of this EULA. This license agreement represents the entire agreement concerning the program between you and Active Apps, (referred to as licenser), and it supersedes any prior proposal, representation, or understanding between the parties. If you do not agree to the terms of this EULA, do not install or use the SOFTWARE PRODUCT.\n" +
					"The SOFTWARE PRODUCT is protected by copyright laws and international copyright treaties, as well as other intellectual property laws and treaties. The SOFTWARE PRODUCT is licensed, not sold.\n" +
					"1. GRANT OF LICENSE.\n" +
					"The SOFTWARE PRODUCT is licensed as follows:\n" +
					"(a) Installation and Use.\n" +
					"Active Apps grants you the right to install and use copies of the SOFTWARE PRODUCT on your computer running a validly licensed copy of the operating system for which the SOFTWARE PRODUCT was designed Android 2.1.\n" +
					"(b) Backup Copies.\n" +
					"You may also make copies of the SOFTWARE PRODUCT as may be necessary for backup and archival purposes.\n" +
					"2. DESCRIPTION OF OTHER RIGHTS AND LIMITATIONS.\n" +
					"(a) Maintenance of Copyright Notices.\n" +
					"You must not remove or alter any copyright notices on any and all copies of the SOFTWARE PRODUCT.\n" +
					"(b) Distribution.\n" +
					"You may not distribute registered copies of the SOFTWARE PRODUCT to third parties. Evaluation versions available for download from Active Apps's websites may be freely distributed.\n" +
					"(c) Prohibition on Reverse Engineering, Decompilation, and Disassembly.\n" +
					"You may not reverse engineer, decompile, or disassemble the SOFTWARE PRODUCT, except and only to the extent that such activity is expressly permitted by applicable law notwithstanding this limitation.\n" +
					"(d) Rental.\n" +
					"You may not rent, lease, or lend the SOFTWARE PRODUCT.\n" +
					"(e) Support Services.\n" +
					"Active Apps may provide you with support services related to the SOFTWARE PRODUCT ('Support Services'). Any supplemental software code provided to you as part of the Support Services shall be considered part of the SOFTWARE PRODUCT and subject to the terms and conditions of this EULA.\n" +
					"(f) Compliance with Applicable Laws.\n" +
					"You must comply with all applicable laws regarding use of the SOFTWARE PRODUCT.\n" +

					"3. TERMINATION\n" +
					"Without prejudice to any other rights, Active Apps may terminate this EULA if you fail to comply with the terms and conditions of this EULA. In such event, you must destroy all copies of the SOFTWARE PRODUCT in your possession.\n" +

					"4. COPYRIGHT\n" +
					"All title, including but not limited to copyrights, in and to the SOFTWARE PRODUCT and any copies thereof are owned by Active Apps or its suppliers. All title and intellectual property rights in and to the content which may be accessed through use of the SOFTWARE PRODUCT is the property of the respective content owner and may be protected by applicable copyright or other intellectual property laws and treaties. This EULA grants you no rights to use such content. All rights not expressly granted are reserved by Active Apps.\n" +

					"5. NO WARRANTIES\n" +
					"Active Apps expressly disclaims any warranty for the SOFTWARE PRODUCT. The SOFTWARE PRODUCT is provided 'As Is' without any express or implied warranty of any kind, including but not limited to any warranties of merchantability, noninfringement, or fitness of a particular purpose. Active Apps does not warrant or assume responsibility for the accuracy or completeness of any information, text, graphics, links or other items contained within the SOFTWARE PRODUCT. Active Apps makes no warranties respecting any harm that may be caused by the transmission of a computer virus, worm, time bomb, logic bomb, or other such computer program. Active Apps further expressly disclaims any warranty or representation to Authorized Users or to any third party.\n" +

					"6. LIMITATION OF LIABILITY\n" +
					"In no event shall Active Apps be liable for any damages (including, without limitation, lost profits, business interruption, or lost information) rising out of 'Authorized Users' use of or inability to use the SOFTWARE PRODUCT, even if Active Apps has been advised of the possibility of such damages. In no event will Active Apps be liable for loss of data or for indirect, special, incidental, consequential (including lost profit), or other damages based in contract, tort or otherwise. Active Apps shall have no liability with respect to the content of the SOFTWARE PRODUCT or any part thereof, including but not limited to errors or omissions contained therein, libel, infringements of rights of publicity, privacy, trademark rights, business interruption, personal injury, loss of privacy, moral rights or the disclosure of confidential information. ");
			builder.create().show();
		}
	}

}
