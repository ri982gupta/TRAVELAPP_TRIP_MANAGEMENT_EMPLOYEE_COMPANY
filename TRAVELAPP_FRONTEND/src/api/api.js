import axios from "axios";
const url = "http://localhost:9004";

export const getTravel = async () => {
  try {
    const response = await axios.get(url + "/api/data/all");
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const travelAPI = async (data) => {
  try {
    console.log(data);
    const response = await axios.post(url + "/api/data/save", data);
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const createAPI = async (data) => {
  try {
    console.log(data);
    const response = await axios.post(url + "/applyForFormData/save", data);
    return response;
  } catch (postError) {
    console.log("POST request failed:", postError);
    console.log("Trying PUT request...");

    try {
      const putResponse = await axios.put(
        url + `/applyForFormData/update/${data.travelId}`,
        data
      );
      return putResponse;
    } catch (putError) {
      console.log("PUT request also failed:", putError);
      throw new Error("Both POST and PUT requests failed");
    }
  }
};

export const loginAPI = async (data) => {
  try {
    console.log(data);
    const response = await axios.post(url + "/api/login/save", data);
    return response;
  } catch (error) {
    console.log(error);
  }
};
