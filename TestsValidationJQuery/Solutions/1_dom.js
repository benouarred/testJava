/**
 * There's a lot of possible solutions to achieve this.
 * Here are some major checks to do :
 * 		- use the $(function() {})
 * 		- never NEVER repeat an existing selector, put it in a var instead
 * 		- use the JQuery function wisely to avoid too much call
 * 		- use context in selector when possible
 */

// One possible solution
$(function() {

	var defaultDivHtml = '<div class="square"></div>',
		colors = ['orange', 'red', 'green', 'blue'];
	
	var sheet = $('#worksheet');
	
	for (var i=0; i < colors.length; i++) {
		sheet.append(defaultDivHtml);
		
		var child = sheet.children('div:last');
		
		child.addClass(colors[i]);
		child.wrap(function() {
			return '<li style="list-style: none;">' + $(this).html() + '</li>';
		});
	}
	
	$('li', sheet).wrapAll('<ul>');
});