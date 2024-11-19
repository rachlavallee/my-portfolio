document.addEventListener("DOMContentLoaded", async()=>{
    const projectsList = document.getElementById("projects");

    try{
        const response = await fetch("/api/projects");
        const projects = await response.json();

        projects.forEach(project=> {
            const li = document.createElement("li");
            li.innerHTML = `<strong>${project.name}</strong>: ${project.description} (<a href="${project.link}" target="_blank">View</a>)`;
            projectsList.appendChild(li);

        });

    }catch(error){
        console.error("Error fetching projects:" + error);
        projectsList.innerHTML = "<li>Unable to load projects at this time.</li>";
    }


});