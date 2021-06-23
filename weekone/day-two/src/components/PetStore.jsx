import React, { useState } from "react";

const PetStore = () => {
  const [petList, setPetList] = useState([]);
  const [petName, setPetName] = useState("");

  const handleNameInput = (event) => {
    setPetName(event.target.value);
  };

  // 
  const handleClick = () => {
    let petObj = { petName: petName };
    
    setPetList([...petList,petName]);
    setPetName("");

    console.log("clicked");
  };

  let arrOfPets = petList.map((animal, idx) => {
      console.log(animal)
    return (
      <div key={idx}>
        <div>Name: {animal}</div>
      </div>
    );
  });

  return (
    <div>
      <h4>List of Animals</h4>
      {arrOfPets}
      <input
        value={petName}
        onChange={handleNameInput}
        placeholder="Pet Name"
      />
      <button onClick={handleClick}>Add Animal</button>
    </div>
  );
};

export default PetStore;
