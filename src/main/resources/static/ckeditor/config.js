/**
 * @license Copyright (c) 2003-2022, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
    config.height = 400;
    config.toolbarCanCollapse = true;
    config.font_names = "맑은 고딕/Malgun Gothic;굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;Arial/Arial;Comic Sans MS/Comic Sans MS;Courier New/Courier New;Georgia/Georgia;Lucida Sans Unicode/Lucida Sans Unicode;Tahoma/Tahoma;Times New Roman/Times New Roman;MS Mincho/MS Mincho;Trebuchet MS/Trebuchet MS;Verdana/Verdana";
    config.filebrowserUploadUrl = "/ckeditor/fileUpload";
    config.font_defaultLabel = "맑은 고딕/Malgun Gothic";
    config.fontSize_defaultLabel = "12";
    config.language = "ko";
    config.removePlugins = "save,elements path";  //  Plug-in 제거
    // config.removePlugins = "resize";  //  Plug-in 제거
    // config.resize_enabled = false;
    // Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
};
