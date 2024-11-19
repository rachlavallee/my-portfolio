document.getElementById("contactForm").addEventListener("submit", async(e)=>{
    e.preventDefault();

    const formData={
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        message: document.getElementById("message").value
    };

    try{
        const response = await fetch("/api/contact", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(formData)
        });

        const result = await response.json();
        document.getElementById("responseMessage").innerTest=result.message;

    }catch(error){
        document.getElementById("responseMessage").innerText="Error sending message. Please try again.";

    }

});