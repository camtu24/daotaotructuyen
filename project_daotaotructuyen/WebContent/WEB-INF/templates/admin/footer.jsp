<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>

<!--end-Footer-part-->

<%-- <script src="${defines.urlAdmin }/js/excanvas.min.js"></script> --%> 
<script src="${defines.urlAdmin }/js/jquery.min.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.ui.custom.js"></script> 
<script src="${defines.urlAdmin }/js/bootstrap.min.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.uniform.js"></script> 
<script src="${defines.urlAdmin }/js/select2.min.js"></script> 
<script src="${defines.urlAdmin }/js/matrix.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.dataTables.min.js"></script>  
<script src="${defines.urlAdmin }/js/matrix.tables.js"></script>
<script src="${defines.urlAdmin }/js/bootstrap-colorpicker.js"></script> 
<script src="${defines.urlAdmin }/js/bootstrap-datepicker.js"></script> 
<script src="${defines.urlAdmin }/js/masked.js"></script>  
<script src="${defines.urlAdmin }/js/matrix.form_common.js"></script> 
<script src="${defines.urlAdmin }/js/wysihtml5-0.3.0.js"></script> 
<script src="${defines.urlAdmin }/js/bootstrap-wysihtml5.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.peity.min.js"></script> 
<script src="${defines.urlAdmin }/js/fullcalendar.min.js"></script> 
<script src="${defines.urlAdmin }/js/matrix.interface.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.validate.js"></script> 
<script src="${defines.urlAdmin }/js/matrix.form_validation.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.wizard.js"></script> 
<script src="${defines.urlAdmin }/js/matrix.popover.js"></script>
<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>

<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>