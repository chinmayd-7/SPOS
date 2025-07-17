const moodData = [
    {
        mood: "Happy",
        color: "#FFF9C4",
        quote: "Keep smiling, it makes people wonder what you're up to."
    },
    {
        mood: "Sad",
        color: "#BBDEFB", 
        quote: "It's okay to feel not okay."
    },
    {
        mood: "Angry",
        color: "#FFCDD2", 
        quote: "Take a deep breath and let it go."
    },
    {
        mood: "Tired",
        color: "#E0E0E0", 
        quote: "Rest if you must, but donʼt quit."
    },
    {
        mood: "Excited",
        color: "#E1BEE7", 
        quote: "Let your excitement be louder than your fears."
    }
];


function change(idx){
    document.body.style.backgroundColor=moodData[idx].color;
    document.getElementById('moodText').textContent=`"${moodData[idx].quote}"`;
    document.getElementById('moodTexth2').textContent=`"${moodData[idx].mood}"`;
}