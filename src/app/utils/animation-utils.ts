declare var $: any;
export class AnimationUtils {
  static tabLoop() {
    $(function () {
        $(document).on(
            "keydown",
            ".tabloop :tabbable:not([readonly])",
            function (e) {
                // Tab key only (code 9)
                if (e.keyCode != 9) return;

                // Get the loop element
                var loop = $(this).closest(".tabloop");

                // Get the first and last tabbable element
                var firstTabbable = loop
                    .find(":tabbable:not([readonly])")
                    .first();
                var lastTabbable = loop
                    .find(":tabbable:not([readonly])")
                    .last();

                // Leaving the first element with Tab : focus the last one
                if (firstTabbable.is(e.target) && e.shiftKey == true) {
                    e.preventDefault();
                    lastTabbable.focus();
                }

                // Leaving the last element with Tab : focus the first one
                if (lastTabbable.is(e.target) && e.shiftKey == false) {
                    e.preventDefault();
                    firstTabbable.focus();
                }
            }
        );
    });

  }

  static focusFirstInput() {
    let firstInp = $(".tabloop").find("input:first");
    let firstInvalidInp = $(".tabloop").find(".is-invalid:first");
    if (firstInvalidInp.length > 0) {
        setTimeout(() => {
            firstInvalidInp.focus();
        }, 100);
    } else {
        setTimeout(() => {
            firstInp.focus();
        }, 100);
    }
  }

}
