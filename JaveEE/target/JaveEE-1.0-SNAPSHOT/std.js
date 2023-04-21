const addNewBtn = document.getElementById("addNew");
const Container = document.querySelector(".addNewContainer ");
const overLay = document.querySelector(".overLay ");
addNewBtn.addEventListener("click", () => {
    Container.classList.toggle("hidden");
    overLay.classList.toggle("hidden");
});
overLay.addEventListener("click", () => {
    Container.classList.toggle("hidden");
    overLay.classList.toggle("hidden");
});
