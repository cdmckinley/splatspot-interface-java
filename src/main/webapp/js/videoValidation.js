// based on https://www.geeksforgeeks.org/form-validation-using-jquery/

// when document is ready
$(document).ready(() => {
    // declare broader-scope variables
    let hasLinkField = false;
    let linkValid = false;
    // if the link field is set in the page, set the script to validate it
    if ($("#link")) {
        hasLinkField = true;
        // validate the link
        // when a key is released and the selection is in the 'link' field, call the validation function
        $("#link").keyup(() => validateLink());
    }

    let validateLink = () => {
        let linkValue = $("#link").val();
        // Link length should be 11 characters
        if (isNaN(linkValue.length)) {
            $("#linkvalid").show();
            linkValid = false;
            return false;
        } else if (linkValue.length !== 11) {
            $("#linkvalid").show();
            linkValid = false;
            return false;
        } else {
            $("#linkvalid").hide();
            return true;
        }
    }

    let descriptionValid = true;
    // when a key is released and the selection is in the 'description' field, call the validation function
    $("#description").keyup(() => validateDescription());

    let validateDescription = () => {
        let descriptionValue = $("#description").val();
        // description should be no more than 500 characters. Can be blank, but recommended to be filled out.
        if (isNaN(descriptionValue.length)) {
            $("#descriptionvalid").show();
            descriptionValid = false;
            return false;
        } else if (descriptionValue.length > 500) {
            $("#descriptionvalid").show();
            descriptionValid = false;
            return false;
        } else if (descriptionValue.length === 0) {
            $("#descriptionvalid").show();
            return true;
        } else {
            $("#descriptionvalid").hide();
            return true;
        }
    }

    $("#submitbutton").submit(() => {
        if (hasLinkField) validateLink();
        validateDescription();
        if ((!hasLinkField || linkValid ) && descriptionValid) return true;
        else return false;
    })
})