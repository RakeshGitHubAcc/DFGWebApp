package com.dfg.showcase;

import org.apache.wicket.protocol.http.WebApplication;

import com.dfg.showcase.formelements.CheckboxGroupPage;
import com.dfg.showcase.formelements.CheckboxPage;
import com.dfg.showcase.formelements.DropDownPage;
import com.dfg.showcase.formelements.RadioGroupPage;
import com.dfg.showcase.formelements.SectionPage;
import com.dfg.showcase.formelements.TextAreaPage;
import com.dfg.showcase.formelements.TextFieldPage;
import com.dfg.showcase.formelements.TextPage;
import com.dfg.showcase.generalusage.UsagePage;
import com.dfg.showcase.metadata.DisabledPage;
import com.dfg.showcase.metadata.LabelPage;
import com.dfg.showcase.metadata.RequiredPage;
import com.dfg.showcase.metadata.UserHintPage;
import com.dfg.showcase.validators.CustomValidatorPage;
import com.dfg.showcase.validators.MinMaxValidatorPage;
import com.dfg.showcase.validators.UrlValidatorPage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<BasePage> getHomePage() {
		return BasePage.class;
	}

	@Override
	public void init() {
		super.init();

		this.getMarkupSettings().setStripWicketTags(true);
		this.getMarkupSettings().setDefaultAfterDisabledLink("");
		this.getMarkupSettings().setDefaultBeforeDisabledLink("");

		this.mountPage("usage", UsagePage.class);
		this.mountPage("section", SectionPage.class);
		this.mountPage("text", TextPage.class);
		this.mountPage("textfield", TextFieldPage.class);
		this.mountPage("textarea", TextAreaPage.class);
		this.mountPage("dropdown", DropDownPage.class);
		this.mountPage("checkbox", CheckboxPage.class);
		this.mountPage("radiogroup", RadioGroupPage.class);
		this.mountPage("checkboxgroup", CheckboxGroupPage.class);
		this.mountPage("label", LabelPage.class);
		this.mountPage("userhint", UserHintPage.class);
		this.mountPage("disabled", DisabledPage.class);
		this.mountPage("required", RequiredPage.class);
		this.mountPage("numbervalidator", MinMaxValidatorPage.class);
		this.mountPage("urlvalidator", UrlValidatorPage.class);
		this.mountPage("customvalidator", CustomValidatorPage.class);

	}
}
