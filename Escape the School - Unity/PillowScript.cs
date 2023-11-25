using UnityEngine;

public class PillowScript : MonoBehaviour
{
    // Start is called before the first frame update

    void OnMouseDown()
    {
        if (transform.position.x > -15)
        {
                
            transform.position = new Vector3(transform.position.x - 3f, transform.position.y, transform.position.z);
        }
    } 
}
