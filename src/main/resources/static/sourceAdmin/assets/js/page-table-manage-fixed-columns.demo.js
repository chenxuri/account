/*   
Template Name: Source Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 1.3.0
Author: Sean Ngu
Website: http://www.seantheme.com/source-admin-v1.3/admin/
*/

var handleDataTableFixedColumns = function() {
    "use strict";

    if ($('#data-table').length !== 0) {
        $('#data-table').DataTable({
            scrollY:        300,
            scrollX:        true,
            scrollCollapse: true,
            paging:         false,
            fixedColumns:   true,
            responsive: true
        });
    }
};


/* Application Controller
------------------------------------------------ */
var PageDemo = function () {
	"use strict";
	
	return {
		//main function
		init: function () {
            handleDataTableFixedColumns();
		}
  };
}();